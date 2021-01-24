package game;

import game.api.AndroidAdapter;
import game.api.PlayStationAdapter;
import game.api.WindowsAdapter;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[] args) {
		// BallGame game = new BallGame(new AndroidAdapter());
		// BallGame game = new BallGame(new WindowsAdapter());
		BallGame game = new BallGame(new PlayStationAdapter());
		game.play();
	}
}
