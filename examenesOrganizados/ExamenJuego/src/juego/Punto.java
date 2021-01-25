package juego;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return String.format("(x: %d, y: %d)", x, y);
	}
	
	public void moverHacia(Punto otro) {
		int dx = x - otro.x;
		int dy = y - otro.y;
		dx /= 10;
		dy /= 10;
		x -= dx;
		y -= dy;
	}
	
	public void moverAbajo() {
		y -= 10;
	}

	public void moverArriba() {
		y += 10;
	}

	public void moverIzquierda() {
		x -= 10;
	}

	public void moverDerecha() {
		x += 10;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
