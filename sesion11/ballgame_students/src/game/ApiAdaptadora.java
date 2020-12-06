package game;

import java.awt.Point;

import platform.Image2D;
import platform.android.AndroidAPI;
import platform.playstation.Playstation5API;
import platform.windows.WindowsAPI;

public class ApiAdaptadora {

	Platform platform;
	private AndroidAPI android;
	private WindowsAPI windows;
	private Playstation5API playstation;

	public ApiAdaptadora(Platform platform) {
		this.platform=platform;
		if (platform == Platform.ANDROID)
			android = new AndroidAPI();
		else if (platform == Platform.WINDOWS)
			windows = new WindowsAPI();
		else
			playstation = new Playstation5API();
	}

	public Image2D loadImage(String name) 
	{
		if (platform == Platform.ANDROID)
			return android.loadResource(name);
		else if (platform == Platform.WINDOWS)
			return windows.loadFile(name);
		else if(platform==Platform.PLAYSTATION)
			return playstation.loadGraphics(name);
		else return null;
	}

	public void drawBall(int x, int y, Image2D image) 
	{
		if (platform == Platform.ANDROID)
			android.draw(x, y, image);
		else if (platform == Platform.WINDOWS)
			windows.paint(x, y, image);
		else if(platform==Platform.PLAYSTATION)
			playstation.render(x, y, image);
	}

	/**
	 * Devuelve la posición en la que el usuario pulsa con un dedo en la pantalla.
	 * @return un objeto punto (Point) con la posición donde el usuario ha tocado
	 *         con el dedo la pantalla
	 */
	public Point getPosition() 
	{
		if (platform == Platform.ANDROID)
			return android.getTouch();
		else if (platform == Platform.WINDOWS)
			return windows.getMouseClick();
		else if(platform==Platform.PLAYSTATION)
			return playstation.getJoystick();
		else return null;
	}

	private Point point = new Point(0, 0);

}
