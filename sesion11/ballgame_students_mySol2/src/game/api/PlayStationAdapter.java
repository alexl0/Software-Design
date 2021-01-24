package game.api;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

public class PlayStationAdapter implements Api {

	private Playstation5API playstationAPI = new Playstation5API();

	@Override
	public Image2D loadImage(String file) {
		return playstationAPI.loadGraphics(file);
	}

	@Override
	public Point getPosition() {
		return playstationAPI.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		playstationAPI.render(point.x, point.y, image);
	}

}
