package src;
import java.util.List;
import java.util.ArrayList;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}

		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

		return result;
	}

	public int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : rentals) {
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : rentals) {
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}

}
