package machine.discount;

public class Discount_15EURACOS implements Discount {

	@Override
	public double getDiscount(double totalPrice, int numberOfTickets) {
		return totalPrice-15;
	}

	@Override
	public String getName() {
		return "15EURACOS";
	}

}
