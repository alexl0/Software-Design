/**
 * Esta clase representa el alquiler de una película por parte de un cliente.
 */
public class Rental 
{
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) 
	{
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() 
	{
		return daysRented;
	}

	public Movie getMovie() 
	{
		return movie;
	}

	/**
	 * Son publicos getCharge() y getFrecuentRentalPoints() porque la responsabilidad recae en la clase rental
	 * Al estar aquí, si nos piden generar el ticket en html, no se repite codigo
	 */
	public double getCharge() {
		return movie.getCharge(daysRented);
	}

	public int getFrecuentRentalPoints() {
		return movie.getFrecuentRentalPoints(this);
	}
}
