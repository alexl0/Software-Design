package herramientas;

import figuras.Figura;

public interface Herramienta {

	Figura getFigura();
	
	void pulsar(int x, int y);

	void mover(int x, int y);

}
