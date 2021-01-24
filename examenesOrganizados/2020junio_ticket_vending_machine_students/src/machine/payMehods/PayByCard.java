package machine.payMehods;

import machine.hardware.CardReader;
import machine.hardware.Display;
import ruralvia.BankGateway;

public class PayByCard implements PayMethod {

	private BankGateway bankGateway = new BankGateway();// pasarela de pagos (para los pagos con tarjeta)
	private CardReader cardReader = new CardReader();
	private Display display = new Display();

	@Override
	public boolean pay(double amount) {
		String cardNumber = cardReader.readCardNumber();
		boolean isValid = bankGateway.pay(cardNumber, amount);
		if (!isValid) {
			display.show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		display.show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

}
