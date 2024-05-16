package ubu.gii;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		int result = daysRented * 3;
		return result;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		int frequentRenterPoints=1;
		// Añadir un bonus si la pelicula es de tipo "NEW RELEASE" y ha sido alquilada durante más de un día
		if (getPriceCode() == Movie.NEW_RELEASE && daysRented >= 2) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}
	

}
