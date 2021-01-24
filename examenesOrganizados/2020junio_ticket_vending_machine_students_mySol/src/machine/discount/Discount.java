package machine.discount;

public interface Discount {
	public double getDiscount(double totalPrice, int numberOfTickets);

	public String getName();
}
