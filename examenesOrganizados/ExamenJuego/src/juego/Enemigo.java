package juego;

public class Enemigo {

	private Nivel nivel;
	private Punto posicion;
	
	private int estado = 0;
	
	public Enemigo(Nivel nivel) {
		this.nivel = nivel;
		this.posicion = new Punto(100, 100);
		System.out.println("Creado nuevo enemigo");
	}

	public void actuar(Personaje personaje) {
		if (nivel == Nivel.FACIL) {
			switch (estado) {
			case 0:
				posicion.moverAbajo();
				estado++;
				break;
			case 1:
				posicion.moverDerecha();
				estado++;
				break;
			case 2:
				posicion.moverIzquierda();
				estado++;
				break;
			case 3:
				posicion.moverArriba();
				estado = 0;
				break;
			}
		}
		else {
			posicion.moverHacia(personaje.getPosicion());
		}
		System.out.println("Enemigo ahora en posicion " + posicion);
	}

	public Punto getPosicion() {
		return posicion;
	}
}
