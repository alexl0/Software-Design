package game;

import platform.adapters.*;

public class Main {
	public static void main(String[] args) {
		BallGame game = new BallGame(new WindowsAPIPlatform());
		game.play();
	}
}
