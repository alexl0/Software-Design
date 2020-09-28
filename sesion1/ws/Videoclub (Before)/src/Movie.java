public class Movie 
{
	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;

	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) 
	{
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() 
	{
		return priceCode;
	}

	public void setPriceCode(int priceCode) 
	{
		this.priceCode = priceCode;
	}

	public String getTitle() 
	{
		return title;
	}

	/**
	 * Son publicos getCharge() y getFrecuentRentalPoints() porque la responsabilidad recae en la clase rental
	 * Al estar aquí, si nos piden generar el ticket en html, no se repite codigo
	 * @param rental TODO
	 */
	public double getCharge(int daysRented) {
		double result=0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) 
				result += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3)
				result += (daysRented - 3) * 1.5;
			break;
		}
		return result;
	}

	public int getFrecuentRentalPoints(Rental rental) {
		int frequentRenterPoints=1;
		// Añade los puntos de alquiler frecuente
		// Un punto extra en el caso de las novedades alquiladas por un período de dos o más días
		if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) 
			frequentRenterPoints++;
		return frequentRenterPoints;
	}	
}
