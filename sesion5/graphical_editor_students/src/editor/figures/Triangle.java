package editor.figures;

import editor.Figure;

public class Triangle implements Figure {

	private int xa=-1;
	private int ya=-1;
	private int xb=-1;
	private int yb=-1;
	private int xc=-1;
	private int yc=-1;
	private boolean acabada=false;

	public int getXa() {
		return xa;
	}

	public void setXa(int xa) {
		this.xa = xa;
	}

	public int getYa() {
		return ya;
	}

	public void setYa(int ya) {
		this.ya = ya;
	}

	public int getXb() {
		return xb;
	}

	public void setXb(int xb) {
		this.xb = xb;
	}

	public int getYb() {
		return yb;
	}

	public void setYb(int yb) {
		this.yb = yb;
	}

	public int getXc() {
		return xc;
	}

	public void setXc(int xc) {
		this.xc = xc;
	}

	public int getYc() {
		return yc;
	}

	public void setYc(int yc) {
		this.yc = yc;
	}


	@Override
	public void dibujar() {
		System.out.println(" - Triangulo: ("+getXa()+", "+getYa()+"), " + "("+getXb()+", "+getYb()+"), " + "("+getXc()+", "+getYc()+"), ");
	}

	@Override
	public boolean isAcabada() {
		return acabada;
	}

	@Override
	public void setAcabada(boolean acabada) {
		this.acabada=acabada;
	}

	@Override
	public boolean seHaPulsado(int xPulsado, int yPulsado) {
		return xPulsado==xa && yPulsado==ya || xPulsado==xb && yPulsado==yb ||xPulsado==xc && yPulsado==yc ;

	}

	@Override
	public void transladar(int x, int y) {
		this.setXa((this.getXa()+x));
		this.setYa((this.getYa()+y));
		this.setXb((this.getXb()+x));
		this.setYb((this.getYb()+y));
		this.setXc((this.getXc()+x));
		this.setYc((this.getYc()+y));
	}

}
