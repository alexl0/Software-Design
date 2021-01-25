package juego;

public class GeneradorEnemigos {

	private Nivel nivel;
	private int contador;
	
	public GeneradorEnemigos(Nivel nivel) {
		this.nivel = nivel;
		if (nivel == Nivel.FACIL)
			this.contador = 0;
	}
	
	public void actuar(Mundo mundo) {
		if (nivel == Nivel.FACIL) {
			contador++;
			if (mundo.hayHuecoEnemigos() && contador > 3) {
				mundo.addEnemigo(new Enemigo(nivel));
				contador = 0;
			}
		}
		else {
			mundo.addEnemigo(new Enemigo(nivel));
		}
	}
}
