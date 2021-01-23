package descuentos;

/**
 * Concrete strategy es una estrategia concreta en este caso el descuento de entradas gratis.
 * @author Fernando Ruiz
 *
 */
public class EntradaGratis implements Descuento {

	@Override
	public double aplicarDescuento(int tickets, double amount) {
		return amount - (amount / tickets);
	}

}
