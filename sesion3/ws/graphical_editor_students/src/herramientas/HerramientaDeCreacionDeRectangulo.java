package herramientas;

import figuras.Figura;
import figuras.Rectangulo;

public class HerramientaDeCreacionDeRectangulo implements Herramienta{

	private Rectangulo rectangulo = new Rectangulo();;

	@Override
	public void pulsar(int x, int y) {
		if(x>=0 && y>=0) {
			rectangulo.setX(x);
			rectangulo.setY(y);
		}

	}

	@Override
	public void mover(int x, int y) {
		if(x>=0 && y>=0) {
			rectangulo.setAlto(x);
			rectangulo.setLargo(y);
		}
	}

	@Override
	public Figura getFigura() {
		return rectangulo;
	}


}
