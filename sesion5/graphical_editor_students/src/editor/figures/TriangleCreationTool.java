package editor.figures;
import editor.Figure;
import editor.tools.Tool;

public class TriangleCreationTool implements Tool {

	private Triangle triangulo = new Triangle();

	@Override
	public Figure getFigura() {
		return triangulo;
	}

	@Override
	public void pulsar(int x, int y) {
		if(x>=0 && y>=0) {
			if(triangulo.getXa()==-1 && triangulo.getYa()==-1) {
				triangulo.setXa(x);
				triangulo.setYa(y);
			}
			else if(triangulo.getXb()==-1 && triangulo.getYb()==-1) {
				triangulo.setXb(x);
				triangulo.setYb(y);
			}
			else if(triangulo.getXc()==-1 && triangulo.getYc()==-1) {
				triangulo.setXc(x);
				triangulo.setYc(y);
				triangulo.setAcabada(true);
			}
		}
	}

	@Override
	public void mover(int x, int y) {
		if(x>=0 && y>=0) {
			if(triangulo.getXb()==-1 && triangulo.getYb()==-1) {
				triangulo.setXb(x);
				triangulo.setYb(y);
			}
			else if(triangulo.getXc()==-1 && triangulo.getYc()==-1) {
				triangulo.setXc(x);
				triangulo.setYc(y);
				triangulo.setAcabada(true);
			}
		}
	}

	@Override
	public String nombreHerramienta() {
		return "Herramienta de creacion de triangulo";
	}

}
