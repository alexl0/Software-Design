package promociones;



public class DescuentoNada implements Descuento {
	//Para el caso en el que lo deje en blanco y diferenciar del caso en el que se equivoca
	//y pone un código promocional inexistente
	@Override
	public double cantidadDescuento(double amount, double precioEntrada) {
		return amount;
	}

}
