package editor.tools;

import editor.Figure;

public interface Tool {

	Figure getFigura();
	void pulsar(int x, int y);
	void mover(int x, int y);
	String nombreHerramienta();

}
