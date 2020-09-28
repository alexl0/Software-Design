package editor;

import java.util.ArrayList;

import figuras.Figura;

public class Drawing 
{
	
	ArrayList<Figura> figuras=new ArrayList<Figura>();
	
	public ArrayList<Figura> getFiguras() {
		return figuras;
	}

	public void setFiguras(ArrayList<Figura> figuras) {
		this.figuras = figuras;
	}

	public void draw()
	{
		// TODO: ¡Implementarlo!
		for(Figura f:figuras) {
			f.dibujar();
		}
	}
}
