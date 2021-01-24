package game.api;

import java.awt.Point;

import platform.Image2D;
import platform.windows.WindowsAPI;

public class WindowsAdapter implements Api {

	WindowsAPI windowsAPI = new WindowsAPI();

	@Override
	public Image2D loadImage(String file) {
		return windowsAPI.loadFile(file);
	}

	@Override
	public Point getPosition() {
		return windowsAPI.getMouseClick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windowsAPI.paint(point.x, point.y, image);
	}

}
