package ubu.gii;

/**
* Tema  Refactorizaciones 
*
* Ejemplo de aplicaci�n de refactorizaciones. Actualizado para colecciones gen�ricas de java 1.5
*
* @author M. Fowler y <A HREF="mailto:clopezno@ubu.es">Carlos L�pez</A>
* @version 1.1
* @see java.io.File
*
*/
import java.util.*;

public class Customer {
	private String _name;
	private List<Rental> _rentals;

	public Customer(String name) {
		_name = name;
		_rentals = new ArrayList<Rental>();

	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental each = rentals.next();
			thisAmount = each.getMovie().determineAmountsForEachMovie(each, thisAmount);
			
			frequentRenterPoints = addFrequentRenterPoints(frequentRenterPoints);
			frequentRenterPoints = each.addBonusForTwoDayNewReleaseRental(frequentRenterPoints, this);
			result = showFiguresForThisRental(result, thisAmount, each);
			totalAmount += thisAmount;
		}
		return addFooterLines(totalAmount, frequentRenterPoints, result);
	}

	private String addFooterLines(double totalAmount, int frequentRenterPoints, String result) {
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	private String showFiguresForThisRental(String result, double thisAmount, Rental each) {
		// show figures for this rental
		result += "\t" + each.getMovie().getTitle() + "\t"
				+ String.valueOf(thisAmount) + "\n";
		return result;
	}

	int addFrequentRenterPoints(int frequentRenterPoints) {
		// add frequent renter points
		frequentRenterPoints++;
		return frequentRenterPoints;
	}
}
