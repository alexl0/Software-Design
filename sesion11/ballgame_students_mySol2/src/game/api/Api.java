package game.api;

import java.awt.Point;

import platform.Image2D;

public interface Api {
	Image2D loadImage(String file);

	Point getPosition();

	void drawBall(Image2D image, Point point);
}
