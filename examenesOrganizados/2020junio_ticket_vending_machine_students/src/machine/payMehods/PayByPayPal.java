package machine.payMehods;

import machine.hardware.Display;
import machine.hardware.Keyboard;
import paypal.PayPalAPI;

public class PayByPayPal implements PayMethod {

	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private PayPalAPI payPal = new PayPalAPI();

	@Override
	public boolean pay(double amount) {
		// mostrar en pantalla "Iniciando sesión en PayPal..."
		display.show("Iniciando sesion en PayPal...\n");

		// pedir nombre de usuario y contraseña por pantalla
		display.show("Username: \n");
		String username = keyboard.readString();
		display.show("Password: \n");
		String password = keyboard.readString();
		String token = payPal.logIn(username, password);
		if (!payPal.isLogged(token))
			// mostrar "Nombre de usuario o contraseña incorrectas" y finalizar
			display.show("Tarjeta aceptada: pago realizado con éxito\n");

		// si el nombre de usuario y contraseña son correctos, PayPal nos
		// habrá devuelto un token válido, que usaremos para realizar el pago
		boolean isValid = payPal.checkout(token, amount);
		return isValid;
	}

}
