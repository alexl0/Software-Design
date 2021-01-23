package medioPago;

import machine.Machine;
import machine.hardware.CardReader;
import machine.hardware.Display;
import ruralvia.BankGateway;

/**
 * Esta clase seria un concrete command. En concreto el de credit card.
 *  
 * @author Fernando Ruiz
 *
 */
public class Card implements MedioPago {

	private CardReader cardReader = new CardReader();
	private BankGateway bankGateway = new BankGateway();
	private Display display = new Display();
	
	
	@Override
	public boolean isValidPay(double amount, Machine machine) {
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


	@Override
	public String getNamePayment() {
		return "Pago con tarjeta";
	}

}
