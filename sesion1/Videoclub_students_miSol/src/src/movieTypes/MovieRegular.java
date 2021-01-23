package src.movieTypes;

public class MovieRegular implements MovieType {

	public static final int REGULAR = 0;

	@Override
	public double getCharge(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 1.5;
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
