package src.movieTypes;

public class MovieNewRelease implements MovieType {

	public static final int NEW_RELEASE = 1;

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;
		return 1;
	}

}
