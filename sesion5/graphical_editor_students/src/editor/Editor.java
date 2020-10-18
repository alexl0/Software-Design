package editor;

import java.util.ArrayList;

import editor.tools.Tool;
import editor.tools.SelectionTool;


public class Editor 
{	
	private Drawing drawing; // el documento de dibujo
	public ArrayList<Tool> herramientas=new ArrayList<Tool>();
	private Tool herramientaUtilizandose;
	ArrayList<Figure> figuras;

	public Editor(Drawing drawing, ArrayList<Tool> herramientas, ArrayList<Figure> figuras)
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

	public ArrayList<Tool> getHerramientas() {
		return herramientas;
	}
	public void setHerramientas(ArrayList<Tool> herramientas) {
		this.herramientas = herramientas;
	}

	public void setHerramientaUtilizandose(Tool herramienta) {
		this.herramientaUtilizandose=herramienta;
	}

	public void drawDocument()
	{
		if(!(herramientaUtilizandose instanceof SelectionTool) && herramientaUtilizandose.getFigura().isAcabada()) {
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
		if(!(herramientaUtilizandose instanceof SelectionTool) && herramientaUtilizandose.getFigura().isAcabada()) {
			drawing.getFiguras().add(herramientaUtilizandose.getFigura());
			setHerramientaUtilizandose(herramientas.get(0));
		}
		setHerramientaUtilizandose(herramientas.get(0));
	}



}
