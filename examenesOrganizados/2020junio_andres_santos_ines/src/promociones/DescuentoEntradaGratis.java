package promociones;



public class DescuentoEntradaGratis implements Descuento{

	//Estrategía concreta
	@Override
	public double cantidadDescuento(double amount, double precioEntrada) {
		double cantidad=amount-precioEntrada;
		if (cantidad<0) {
			return 0;
		}else {
			return cantidad;
		}
		
	}

}
