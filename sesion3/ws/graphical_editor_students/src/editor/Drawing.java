package editor;

import java.util.ArrayList;

import figuras.Figura;

public class Drawing 
{

	ArrayList<Figura> figuras;

	public Drawing(ArrayList<Figura> figuras) {
		this.figuras=figuras;
	}

	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void draw()
	{
		for(Figura f:figuras) {
			f.dibujar();
		}
	}
}
