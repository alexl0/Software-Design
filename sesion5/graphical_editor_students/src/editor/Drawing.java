package editor;

import java.util.ArrayList;

public class Drawing 
{

	ArrayList<Figure> figuras;

	public Drawing(ArrayList<Figure> figuras) {
		this.figuras=figuras;
	}

	public ArrayList<Figure> getFiguras() {
		return figuras;
	}

	public void draw()
	{
		for(Figure f:figuras) {
			f.dibujar();
		}
	}
}
