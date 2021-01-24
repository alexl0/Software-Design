
package machine.discount;

public class Discount_VERANO20 implements Discount {

	@Override
	public double getDiscount(double totalPrice, int numberOfTickets) {
		return totalPrice*0.2;
	}

	@Override
	public String getName() {
		return "VERANO20";
	}

}
