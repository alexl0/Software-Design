package editor;

import herramientas.Herramienta;
import herramientas.HerramientaDeSeleccion;

public class Editor 
{	
	private Drawing drawing; // el documento de dibujo

	private Herramienta herramienta;

	public Editor(Drawing drawing)
	{
		setDrawing(drawing);
	}

	public Drawing getDrawing()
	{
		return drawing;
	}

	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}

	public void drawDocument()
	{
		drawing.draw();
	}

	public void setHerramienta(Herramienta herramienta) {
		this.herramienta=herramienta;
	}

	public void pulsar(int x, int y) {
		herramienta.pulsar(x,y);
	}

	public void mover(int x, int y) {
		herramienta.mover(x,y);
	}

	public void soltar(HerramientaDeSeleccion herramientaDeSeleccion) {
		drawing.getFiguras().add(herramienta.getFigura());
		setHerramienta(herramientaDeSeleccion);
	}



}
