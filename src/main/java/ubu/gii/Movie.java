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

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private String _title;
	private Price _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public Price getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR: 
			_priceCode = new RegularPrice();
			break;
		case CHILDRENS:
			_priceCode = new ChildrenPrice();
			break;
		case NEW_RELEASE:
			_priceCode = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("No se reconoce el PriceCode especificado"); 
		}
	}

	public String getTitle() {
		return _title;
	}

	double determineAmountsForEachMovie(Rental rental, double thisAmount) {
		
		if (rental.getMovie().getPriceCode() instanceof RegularPrice) {
			thisAmount = new RegularPrice().getCharge(rental.getDaysRented());
		} else if (rental.getMovie().getPriceCode() instanceof NewReleasePrice) {
			thisAmount = new NewReleasePrice().getCharge(rental.getDaysRented());
		} else if (rental.getMovie().getPriceCode() instanceof ChildrenPrice) {
			thisAmount = new ChildrenPrice().getCharge(rental.getDaysRented());
		}
		
		return thisAmount;
	}
}
