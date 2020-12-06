package herramientas;

import java.util.ArrayList;

import figuras.Figura;

public class HerramientaDeSeleccion implements Herramienta {

	ArrayList<Figura> figuras;
	Figura figuraPulsada;
	private int xPulsado;
	private int yPulsado;

	public HerramientaDeSeleccion(ArrayList<Figura> figuras) {
		this.figuras=figuras;
	}

	@Override
	public void pulsar(int x, int y) {
		for(Figura f:figuras) {
			if(f.seHaPulsado(x, y)) {
				figuraPulsada=f;
			}
		}
		xPulsado=x;
		yPulsado=y;
	}

	@Override
	public void mover(int x, int y) {
		figuraPulsada.transladar(x-xPulsado, y-yPulsado);

	}

	@Override
	public Figura getFigura() {
		return figuraPulsada;
	}

	@Override
	public String nombreHerramienta() {
		return "Herramienta de seleccion";
	}


}
