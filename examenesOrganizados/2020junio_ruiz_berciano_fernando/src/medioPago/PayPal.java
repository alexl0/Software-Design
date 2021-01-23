package medioPago;

import machine.Machine;
import paypal.PayPalAPI;

/**
 * Esta clase seria un concrete command. En concreto el de paypal.
 *  
 * @author Fernando Ruiz
 *
 */
public class PayPal implements MedioPago {

	private PayPalAPI api = new PayPalAPI();

	@Override
	public boolean isValidPay(double amount, Machine machine) {
		machine.getDisplay().show("Introduzca username: \n");
		String username = machine.getKeyboard().readString();
		machine.getDisplay().show("Introduzca password: \n");
		String password = machine.getKeyboard().readString();

		String token = api.logIn(username, password);

		if (!api.isLogged(token)) {
			machine.getDisplay().show("Username o password incorrectas");
			return false;
		} else {
			machine.getDisplay().show("Username o password correctos!");
		}

		return api.checkout(token, amount);
	}

	@Override
	public String getNamePayment() {
		return "Pago con PayPal";
	}

}
