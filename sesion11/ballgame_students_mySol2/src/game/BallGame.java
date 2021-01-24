package game;

import java.awt.Point;

import game.api.Api;
import platform.*;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */

enum Platform {
	ANDROID, WINDOWS, PLAYSTATION
};

public class BallGame {

	private Api api;

	public BallGame(Api api) {
		this.api = api;
	}

	public void play() {

		Image2D image = api.loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = api.getPosition();
			api.drawBall(image, point);
		}
	}

}
