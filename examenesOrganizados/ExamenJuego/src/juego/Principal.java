package juego;

import juego.Teclado.TipoEstado;

public class Principal {

	public static void main(String[] args) {
		Teclado teclado = new Teclado();
		
		System.out.println("JUEGO EN NIVEL FACIL");
		Mundo mundo = new Mundo(Nivel.FACIL, teclado);
		
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_ABAJO);
		mundo.avanzar();
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_DISPARO);
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_ARRIBA);
		mundo.avanzar();
		mundo.avanzar();

		System.out.println();
		System.out.println("JUEGO EN NIVEL DIFICIL");
		mundo = new Mundo(Nivel.DIFICIL, teclado);
		
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_ABAJO);
		mundo.avanzar();
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_DISPARO);
		mundo.avanzar();
		teclado.setEstado(TipoEstado.PULSADA_ARRIBA);
		mundo.avanzar();
		mundo.avanzar();

	}
}
