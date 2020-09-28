package figuras;

public class Circulo implements Figura {

	private int x=-1;
	private int y=-1;
	private int alto=-1;
	private int largo=-1;
	private int radio=-1;
	private boolean acabada=false;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	@Override
	public void dibujar() {
		System.out.println(" - Circulo: ("+getX()+", "+getY()+"), radio = "+getRadio());
	}

	@Override
	public boolean isAcabada() {
		return acabada;
	}

	@Override
	public void setAcabada(boolean acabada) {
		this.acabada = acabada;
	}

}