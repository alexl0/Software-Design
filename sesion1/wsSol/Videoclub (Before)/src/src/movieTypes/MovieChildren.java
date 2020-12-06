package src.movieTypes;

public class MovieChildren implements MovieType {

	public static final int CHILDRENS = 2;

	@Override
	public double getCharge(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
