package machine.discount;

public class Discount_FREE1 implements Discount {

	@Override
	public double getDiscount(double totalPrice, int numberOfTickets) {
		return totalPrice/numberOfTickets;
	}

	@Override
	public String getName() {
		return "FREE1";
	}

}
