package figuras;

public interface Figura {

	void dibujar();
	boolean isAcabada();
	void setAcabada(boolean acabada);
	boolean seHaPulsado(int x, int y);
	void transladar(int x, int y);
	
}
