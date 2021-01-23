package descuentos;

/**
 * Concrete strategy es una estrategia concreta en este caso el descuento porcentaje.
 * @author Fernando Ruiz
 *
 */
public class Porcentaje implements Descuento {

	double percentaje;

	public Porcentaje(double percentaje) {
		this.percentaje = percentaje;
	}

	@Override
	public double aplicarDescuento(int tickets, double amount) {
		return amount - (amount * percentaje / 100);
	}

}
