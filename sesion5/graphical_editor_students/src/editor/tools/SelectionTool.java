package editor.tools;

import java.util.ArrayList;

import editor.Figure;

public class SelectionTool implements Tool {

	ArrayList<Figure> figuras;
	Figure figuraPulsada;
	private int xPulsado;
	private int yPulsado;

	public SelectionTool(ArrayList<Figure> figuras) {
		this.figuras=figuras;
	}

	@Override
	public void pulsar(int x, int y) {
		for(Figure f:figuras) {
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
	public Figure getFigura() {
		return figuraPulsada;
	}

	@Override
	public String nombreHerramienta() {
		return "Herramienta de seleccion";
	}


}
