package juego;

import juego.Teclado.TipoEstado;

public class Personaje {

	private Nivel nivel;
	private Punto posicion;
	
	public Personaje(Nivel nivel) {
		this.nivel = nivel;
		this.posicion = new Punto(0, 0);
	}
	
	public Punto getPosicion() {
		return posicion;
	}

	public void actuar(Teclado teclado, Mundo mundo) {
		if (nivel == Nivel.FACIL) {
			if (mundo.getPrimerEnemigo() != null) {
				posicion.moverHacia(mundo.getPrimerEnemigo().getPosicion());
			}
			if (teclado.getEstado() == TipoEstado.PULSADA_DISPARO) {
				System.out.println("Disparo del personaje");
			}
		}
		else {
			switch (teclado.getEstado()) {
			case PULSADA_ABAJO:
				posicion.moverAbajo();
				break;
			case PULSADA_ARRIBA:
				posicion.moverArriba();
				break;
			case PULSADA_DERECHA:
				posicion.moverDerecha();
				break;
			case PULSADA_IZQUIERDA:
				posicion.moverIzquierda();
				break;
			case PULSADA_DISPARO:
				System.out.println("Disparo del personaje");
				break;
			default:
				break;
			}
		}
		System.out.println("Personaje ahora en posicion " + posicion);
	}
}