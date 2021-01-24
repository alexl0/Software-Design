package paymentmode;

import machine.Machine;
import paypal.PayPalAPI;
//Estrategía concreta
//Además de esto es el Adaptador de la clase PayPalAPI.
public class PayPal implements PaymentMode{

	
	private PayPalAPI payPalApi=new PayPalAPI();
	
	private String description;
	
	public PayPal(String description) {
		this.description=description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	
	//Sería la petición, que llama a lo necesario de payPalApi
	@Override
	public boolean isValidPayment(double amount, Machine machine) {
		machine.getDisplay().show("User:\t");
		String username=machine.getKeyboard().readString();
		machine.getDisplay().show("Password:\t");
		String password=machine.getKeyboard().readString();
		String token=payPalApi.logIn(username, password);
		if (!payPalApi.isLogged(token)) {
			return payPalApi.checkout(token, amount);
		}else {
			return false;
		}
		
	}

}
