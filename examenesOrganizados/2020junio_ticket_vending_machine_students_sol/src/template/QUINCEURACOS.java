package template;

//Patron Template
//Es el elemento ConcreteClass que implementa las operaciones definidas en la clase superior abstracta

public class QUINCEURACOS extends ApplyCode {

	@Override
	public double applyCode(double amount, double eventPrice) {
		System.out.println("Código de descuento aplicado.");
		return amount - 15.00;
	}

}
