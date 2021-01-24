package paymentmode;

import machine.Machine;

public interface PaymentMode {
	//Strategy
	boolean isValidPayment(double amount,Machine machine);
	
	String getDescription();

}
