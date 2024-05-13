package ubu.gii;

public class ChildrenPrice extends Price {

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return  Movie.CHILDRENS;
	}

	@Override
	public double getCharge(int daysRented) {
		double result=1.5;

		if (daysRented > 3)
			result += (daysRented- 3) * 1.5;
		return result;
	}

	@Override
	public int getFrequentRenterPoint(int daysRented) {
			
		return 1;
	}

}
