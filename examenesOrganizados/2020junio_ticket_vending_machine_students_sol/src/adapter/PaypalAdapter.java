package adapter;

//Patron Adapter
//Adapter
//Este seria el adaptador especifico que implementa la interfaz Adapter transformando las peticiones provenientes de Paypal al lenguaje de la maquina


import machine.hardware.Display;
import machine.hardware.Keyboard;
import paypal.PayPalAPI;

public class PaypalAdapter implements Adapter {

	PayPalAPI paypalApi;
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	String token;

	public PaypalAdapter() {
		paypalApi = new PayPalAPI();
	}

	@Override
	public void pay(double amount) {
		paypalApi.checkout(token,	amount);

	}

	@Override
	public boolean isValid() {
		display.show("\nIntroduzca nombre de usuario de PayPal: ");
		String user = keyboard.readString();

		display.show("\nIntroduzca contraseña de PayPal: ");
		String pass = keyboard.readString();
		token	=	paypalApi.logIn(user,	pass);	

		if	(!paypalApi.isLogged(token)) {
			display.show("\nNombre	de	usuario	o	contraseña	incorrectas.");
			return false;

		}
		return true;
	}

}
