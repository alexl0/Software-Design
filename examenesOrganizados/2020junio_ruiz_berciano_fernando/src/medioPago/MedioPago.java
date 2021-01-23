package medioPago;

import machine.Machine;

/**
 * Patron Command
 * Esta es la interfaz del patrón command, define la interfaz para ejecutar la operacion
 * 
 * @author Fernando Ruiz
 *
 */
public interface MedioPago {

	//Este metodo es el encargado de comprobar que es valido el metodo de pago.
	boolean isValidPay(double amount, Machine machine);
	
	//Este metodo lo uso para mostrar el tipo de pago
	String getNamePayment();
}
