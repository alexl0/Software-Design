package editor;

import java.util.ArrayList;

import figuras.Figura;
import herramientas.Herramienta;
import herramientas.HerramientaDeSeleccion;

public class Editor 
{	
	private Drawing drawing; // el documento de dibujo
	public ArrayList<Herramienta> herramientas=new ArrayList<Herramienta>();
	private Herramienta herramientaUtilizandose;
	ArrayList<Figura> figuras;

	public Editor(Drawing drawing, ArrayList<Herramienta> herramientas, ArrayList<Figura> figuras)
	{
		setDrawing(drawing);
		setHerramientas(herramientas);
		setHerramientaUtilizandose(herramientas.get(0));
		this.figuras=figuras;
	}

	public Drawing getDrawing()
	{
		return drawing;
	}
	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}

	public ArrayList<Herramienta> getHerramientas() {
		return herramientas;
	}
	public void setHerramientas(ArrayList<Herramienta> herramientas) {
		this.herramientas = herramientas;
	}

	public void setHerramientaUtilizandose(Herramienta herramienta) {
		this.herramientaUtilizandose=herramienta;
	}

	public void drawDocument()
	{
		if(!(herramientaUtilizandose instanceof HerramientaDeSeleccion) && herramientaUtilizandose.getFigura().isAcabada()) {
			drawing.getFiguras().add(herramientaUtilizandose.getFigura());
			setHerramientaUtilizandose(herramientas.get(0));
		}

		System.out.println("Herramienta seleccionada: " + herramientaUtilizandose.nombreHerramienta());
		drawing.draw();
	}

	public void pulsar(int x, int y) {
		herramientaUtilizandose.pulsar(x,y);
	}

	public void mover(int x, int y) {
		herramientaUtilizandose.mover(x,y);
	}

	public void soltar() {
		if(!(herramientaUtilizandose instanceof HerramientaDeSeleccion) && herramientaUtilizandose.getFigura().isAcabada()) {
			drawing.getFiguras().add(herramientaUtilizandose.getFigura());
			setHerramientaUtilizandose(herramientas.get(0));
		}
		setHerramientaUtilizandose(herramientas.get(0));
	}



}
