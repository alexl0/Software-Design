package editor;

import java.util.ArrayList;

import figuras.Figura;

public class Drawing 
{
	
	ArrayList<Figura> figuras=new ArrayList<Figura>();
	
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
