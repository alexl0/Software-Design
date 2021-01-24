package promociones;



public interface Descuento {
	//Cada tipo de descuento se calcula de forma diferente: Strategy
	//Existen 3 dados, de cantidad fija, de entrada gratuita, y de porcentaje, y añadi uno
	//que no hace nada para la opción de ponerlo en blanco y diferenciarlo de la opción
	//en la que el usuairo pone un código promocional inexistente
	double cantidadDescuento(double amount, double precioEntrada);

}
