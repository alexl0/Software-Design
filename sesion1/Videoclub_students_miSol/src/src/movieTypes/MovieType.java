package src.movieTypes;

public interface MovieType {
	double getCharge(int daysRented);

	int getFrequentRenterPoints(int daysRented);
}
