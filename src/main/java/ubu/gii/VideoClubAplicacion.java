package ubu.gii;
public class VideoClubAplicacion {

	public static void main(String[] arg) {
		Movie m11 = new Movie("Sky Captain", 1);
		Movie m12 = new Movie("Alejandro Magno", 1);
		Movie m01 = new Movie("Accion Mutante", 0);
		Movie m2 = new Movie("Hermano Oso", 2);
		Movie m02 = new Movie("Dune", 0);

		Customer c1 = new Customer("Manuel");
		
		Rental r1 = new Rental(m11, 5);
		Rental r2 = new Rental(m01, 1);
		Rental r3 = new Rental(m2, 10);
		Rental r4 = new Rental(m02,6);

		c1.addRental(r1);
		c1.addRental(r2);
		c1.addRental(r3);
		c1.addRental(r4);
		
		
		System.out.println(c1.statement());
		System.out.println(c1.htmlStatement());

	}

}