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

	public int getPriceCode() {
		return _priceCode.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg){
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
			throw new IllegalArgumentException("Incorrect PriceCode");            
		}
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		return _priceCode.getCharge(daysRented);
	}

	public int getFrequentRenterPoint(int daysRented) {
		int frequentRenterPoints=1;
		// add bonus for a two day new release rental
		if ((getPriceCode() == Movie.NEW_RELEASE)
				&& daysRented> 1)
			frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
