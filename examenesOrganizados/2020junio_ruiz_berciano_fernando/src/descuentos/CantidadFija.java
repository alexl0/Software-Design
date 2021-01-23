package descuentos;

/**
 * Concrete strategy es una estrategia concreta en este caso el descuento de cantidad fijo.
 * @author Fernando Ruiz
 *
 */
public class CantidadFija implements Descuento {

	private double descuento;

	public CantidadFija(double descuento) {
		this.descuento = descuento;
	}

	@Override
	public double aplicarDescuento(int tickets, double amount) {
		if(amount - descuento > 0) {
			return (amount - descuento);
		} else {
			return 0;
		}
	}

}
