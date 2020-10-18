package editor.figures;
import editor.Figure;
import editor.tools.Tool;

public class RectangleCreationTool implements Tool{

	private Rectangle rectangulo = new Rectangle();;

	@Override
	public Figure getFigura() {
		return rectangulo;
	}

	@Override
	public void pulsar(int x, int y) {
		if(x>=0 && y>=0) {
			rectangulo.setX(x);
			rectangulo.setY(y);
		}
	}

	@Override
	public void mover(int x, int y) {
		if(x>=0 && y>=0) {
			rectangulo.setAlto(x);
			rectangulo.setLargo(y);
			rectangulo.setAcabada(true);
		}
	}

	@Override
	public String nombreHerramienta() {
		return "Herramienta de creacion de rectangulo";
	}


}
