package ubu.gii;
/**
 * Tema Refactorizaciones
 * 
 * Ejemplo de aplicación de refactorizaciones. Actualizado para colecciones
 * genéricas de java 1.5.
 * 
 * @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos López</A>
 * @version 1.1
 * @see java.io.File
 * 
 */
public class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	int addBonusForTwoDayNewReleaseRental(int frequentRenterPoints, Customer customer) {
		
		if (getMovie().getPriceCode() instanceof NewReleasePrice) {
			frequentRenterPoints += new NewReleasePrice().getFrequentRenterPoint(getDaysRented());
		} else if (getMovie().getPriceCode() instanceof RegularPrice) {
			frequentRenterPoints += new RegularPrice().getFrequentRenterPoint(getDaysRented());
		} else if (getMovie().getPriceCode() instanceof ChildrenPrice) {
			frequentRenterPoints += new ChildrenPrice().getFrequentRenterPoint(getDaysRented());
		}
		
		return frequentRenterPoints;
			
	}

}
