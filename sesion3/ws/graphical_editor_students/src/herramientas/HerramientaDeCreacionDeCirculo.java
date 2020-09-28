package herramientas;

import figuras.Circulo;
import figuras.Figura;

public class HerramientaDeCreacionDeCirculo implements Herramienta {

	private Circulo circulo = new Circulo();
	
	@Override
	public Figura getFigura() {
		return circulo;
	}

	@Override
	public void pulsar(int x, int y) {
		if(x>=0 && y>=0) {
			circulo.setX(x);
			circulo.setY(y);
		}
	}

	@Override
	public void mover(int x, int y) {
		if(x>=0 && y>=0) {
			circulo.setX((circulo.getX()+x)/2);
			circulo.setY((circulo.getY()+x)/2);
			circulo.setRadio(x-circulo.getX());
			circulo.setAcabada(true);
		}
	}

	@Override
	public String nombreHerramienta() {
		return "Herramienta de creacion de circulo";
	}

}
