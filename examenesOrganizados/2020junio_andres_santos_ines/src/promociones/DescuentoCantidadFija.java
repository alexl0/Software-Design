package promociones;



public class DescuentoCantidadFija implements Descuento {

	//Estrategía concreta
	private double cantidadFija;
	
	public DescuentoCantidadFija(int cantidad) {
		this.cantidadFija=cantidad;
	}
	
	@Override
	public double cantidadDescuento(double amount, double precioEntrada) {
		if (amount<cantidadFija) {
			return 0;
		}
		return amount-cantidadFija;
	}

}
