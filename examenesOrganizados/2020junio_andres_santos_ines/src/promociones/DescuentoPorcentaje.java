package promociones;



public class DescuentoPorcentaje implements Descuento {

	//Estrategía concreta
	private double porcentaje;
	
	public DescuentoPorcentaje(int porcentaje) {
		this.porcentaje=porcentaje;
	}
	
	@Override
	public double cantidadDescuento(double amount, double precioEntrada) {
		if (porcentaje>100) {
			return 0;
		}else {
			return amount-amount*(porcentaje/100);
		}
	}

}
