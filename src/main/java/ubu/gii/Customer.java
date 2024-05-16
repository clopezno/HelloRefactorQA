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
		return statement(false);
	}

	public String statement(boolean isHtml) {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = _rentals.iterator();
		String result = null;
		
		if (!isHtml) {
			result = "Rental Record for " + getName() + "\n";
		} else {
			result = "<h1>Rental Record for " + getName() + "</h1>\n";
		}
		
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental alquilerActual = rentals.next();
			thisAmount = alquilerActual.getMovie().determineAmountsForEachMovie(alquilerActual, thisAmount);
			frequentRenterPoints = alquilerActual.addBonusForTwoDayNewReleaseRental(frequentRenterPoints, this);
			result = showFiguresForThisRental(result, thisAmount, alquilerActual, isHtml);
			totalAmount += thisAmount;
		}
		return addFooterLines(totalAmount, frequentRenterPoints, result, isHtml);
	}

	private String addFooterLines(double totalAmount, int frequentRenterPoints, String result, boolean isHtml) {
	    if (isHtml) {
	        result += "<p>Amount owed is <em>" + String.valueOf(totalAmount) + "</em></p>\n";
	        result += "<p>You earned <em>" + String.valueOf(frequentRenterPoints) +
	                "</em> frequent renter points</p>";
	    } else {
	        // add footer lines
	        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
	        result += "You earned " + String.valueOf(frequentRenterPoints) +
	                " frequent renter points";
	    }
	    return result;
	}

	private String showFiguresForThisRental(String result, double thisAmount, Rental each, boolean isHtml) {
	    if (isHtml) {
	        result += "<p>" + each.getMovie().getTitle() + " - " +
	                String.valueOf(thisAmount) + "</p>\n";
	    } else {
	        // show figures for this rental
	        result += "\t" + each.getMovie().getTitle() + "\t" +
	                String.valueOf(thisAmount) + "\n";
	    }
	    return result;
	}

}
