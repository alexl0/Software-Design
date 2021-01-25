package juego;

import java.util.ArrayList;
import java.util.List;

public class Mundo {

	private Personaje personaje;
	private List<Enemigo> enemigos = new ArrayList<>();
	private GeneradorEnemigos generador;
	private Teclado teclado;
	
	public Mundo(Nivel nivel, Teclado teclado) {
		personaje = new Personaje(nivel);
		generador = new GeneradorEnemigos(nivel);
		this.teclado = teclado;
	}

	public Enemigo getPrimerEnemigo() {
		if (enemigos.isEmpty()) return null;
		else return enemigos.get(0);
	}

	public boolean hayHuecoEnemigos() {
		for (Enemigo enemigo: enemigos) {
			if (enemigo.getPosicion().equals(new Punto(100, 100))) {
				return false;
			}
		}
		return true;
	}

	public void addEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);		
	}
	
	public void avanzar() {
		personaje.actuar(teclado, this);
		for (Enemigo enemigo: enemigos) enemigo.actuar(personaje);
		generador.actuar(this);
	}
	
}
