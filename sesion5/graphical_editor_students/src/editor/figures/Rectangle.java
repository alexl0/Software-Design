package editor.figures;

import editor.Figure;

public class Rectangle implements Figure {

	private int x=-1;
	private int y=-1;
	private int largo=-1;
	private int alto=-1;
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
	public int getLargo() {
		return largo;
	}
	public void setLargo(int longitud) {
		this.largo = longitud;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int altitud) {
		this.alto = altitud;
	}

	@Override
	public boolean isAcabada() {
		return acabada;
	}
	@Override
	public void setAcabada(boolean acabada) {
		this.acabada=acabada;
	}

	/**
	 * Ejemplo de salida:  - Rectßngulo: (50, 50), ancho = 50, alto = 50
	 */
	@Override
	public void dibujar() {
		System.out.println(" - Rectangulo: ("+getX()+", "+getY()+"), ancho = "+getLargo()+", alto = "+getAlto());
	}
	@Override
	public boolean seHaPulsado(int xPulsado, int yPulsado) {
		return (x <= xPulsado && xPulsado <= x + largo) && (y <= yPulsado && yPulsado <= y + alto);
	}
	@Override
	public void transladar(int x, int y) {
		this.setX((this.getX()+x));
		this.setY((this.getY()+y));
	}

}
