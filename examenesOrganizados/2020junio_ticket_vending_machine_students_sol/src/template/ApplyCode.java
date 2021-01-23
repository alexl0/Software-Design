package template;

//Patron Template
//Es la clase abstracta donde se definen las operaciones abstractas que redefiniran las subclases
//Es posible que en el futuro se rediseñe una logica más similar en los descuentos por lo que el template es el patron correcto para compartir esa logica.

public abstract class ApplyCode {

	public abstract double applyCode(double amount, double eventPrice);
}
