package figuras;

public class Circulo implements Figura {

	private int x=-1;
	private int y=-1;
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

	@Override
	public boolean seHaPulsado(int xPulsado, int yPulsado) {
		double distancia = Math.sqrt(Math.pow(xPulsado - x, 2) + Math.pow(yPulsado - y, 2));
		return distancia < radio;
	}

	@Override
	public void transladar(int x, int y) {
		this.setX((this.getX()+x));
		this.setY((this.getY()+y));
	}

}
