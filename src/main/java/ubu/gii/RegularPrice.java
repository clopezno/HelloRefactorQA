package ubu.gii;

public class RegularPrice extends Price{

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2) {
			result += (daysRented - 2) * 1.5;
		}
		return result;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
		return 1;
	}

}
