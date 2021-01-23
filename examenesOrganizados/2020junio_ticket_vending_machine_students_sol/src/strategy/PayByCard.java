package strategy;

//Patrón Strategy
//Esta sería la clase ConcreteStrategy donde implementa los distintos algoritmos de la interfaz Strategy

import machine.hardware.CardReader;
import machine.hardware.Display;
import ruralvia.BankGateway;

public class PayByCard implements Pay {
	private CardReader cardReader = new CardReader();
	private BankGateway bankGateway = new BankGateway();
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
