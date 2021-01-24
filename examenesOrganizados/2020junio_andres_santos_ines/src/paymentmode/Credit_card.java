package paymentmode;

import machine.Machine;
//Estrategía concreta
public class Credit_card implements PaymentMode{

	private String description;
	
	public Credit_card(String description) {
		this.description=description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public boolean isValidPayment(double amount,Machine machine) {
		String cardNumber = machine.getCardReader().readCardNumber();
		boolean isValid = machine.getBankGateway().pay(cardNumber, amount);
		if (!isValid) {
			machine.getDisplay().show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		machine.getDisplay().show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;		
	}

}
