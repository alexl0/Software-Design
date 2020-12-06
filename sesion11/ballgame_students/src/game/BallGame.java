package game;

import java.awt.Point;
import platform.*;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */

enum Platform {
	ANDROID, WINDOWS, PLAYSTATION
};

public class BallGame 
{
	// Decide para qué plataform queremos generar el juego
	private Platform platform = Platform.ANDROID;
	// private Platform platform = Platform.WINDOWS;
	// private Platform platform = Platform.PLAYSTATION;

	private ApiAdaptadora apiAdaptadora;

	public void play(){
		// se inicializa la API adecuada para cada plataforma
		setAPI();

		Image2D image = loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			drawBall(image, point);
		}
	}

	private void setAPI(){
		apiAdaptadora=new ApiAdaptadora(platform);
	}

	private Image2D loadImage(String file){
		return apiAdaptadora.loadImage(file);
	}

	private Point getPosition(){
		return apiAdaptadora.getPosition();
	}

	private void drawBall(Image2D image, Point point){
		apiAdaptadora.drawBall(point.x, point.y, image);
	}
}
