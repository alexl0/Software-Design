package descuentos;

/**
 * Patron Strategy
 * Esta es la interfaz comun para el strategy con el metodo comun de los descuentos.
 * 
 * @author Fernando Ruiz
 *
 */
public interface Descuento {

	public double aplicarDescuento(int tickets, double amount);
}
