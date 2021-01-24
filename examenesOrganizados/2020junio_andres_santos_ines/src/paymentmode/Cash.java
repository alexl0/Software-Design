package paymentmode;

import machine.Machine;

//Las subclases tienen un método getDescrpicion que se podría haber hecho como en las promociones
//y haber utilizado un hashmap con <String,PaymentMode> pero en este caso decidí hacerlo así.
//Estrategía concreta
public class Cash implements PaymentMode{

	private String description;
	
	public Cash(String description) {
		this.description=description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public boolean isValidPayment(double amount,Machine machine) {
		int insertedAmount = 0;
		boolean cancel = false;
		machine.getBillAcceptor().reset();
		do {
			machine.getDisplay().show(String.format("Quedan por pagar %.2f €%n", amount - insertedAmount));
			double inserted = machine.getBillAcceptor().insertBill();
			insertedAmount = machine.getBillAcceptor().getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amount && !cancel);
		
		if (cancel) {
			machine.getDisplay().show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				machine.getBillAcceptor().returnChange(insertedAmount);
			return false;
		}
		machine.getDisplay().show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amount) {
			machine.getBillAcceptor().returnChange(insertedAmount - amount);
		} 
		return true;	
	}

	

}
