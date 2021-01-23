package src;

import src.movieTypes.MovieChildren;
import src.movieTypes.MovieNewRelease;
import src.movieTypes.MovieRegular;
import src.movieTypes.MovieType;

public class Movie {

	public static final MovieType REGULAR = new MovieRegular();
	public static final MovieType CHILDRENS = new MovieChildren();
	public static final MovieType NEW_RELEASE = new MovieNewRelease();
	
	private String title;
	private MovieType movieType;

	public Movie(String title, MovieType movieType) {
		this.title = title;
		this.movieType=movieType;
	}

	public String getTitle() {
		return title;
	}

	public double getCharge(int daysRented) {
		return movieType.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return movieType.getFrequentRenterPoints(daysRented);
	}
}
