public class main {
    public static void main(String[] args) {
        //create movie and rental examples
        childrenMovieRental childMovie = new childrenMovieRental("Batman Jr.", 3);
        regularMovieRental regularMovie = new regularMovieRental("Superman 9", 1.5);
        newReleaseMovieRental normalMovie = new newReleaseMovieRental("Iron Man 10", 3.0);

        Rental rental1 = new Rental(childMovie, 10);
        Rental rental2 = new Rental(regularMovie, 5);
        Rental rental3 = new Rental(normalMovie, 7);
        Rental rental4 = new Rental(normalMovie, 7);

        //fresh customer
        Customer testCustomer = new Customer("Daniel", 0);

        testCustomer.addRental(rental1);
        testCustomer.addRental(rental2);
        testCustomer.addRental(rental3);
        testCustomer.addRental(rental4);

        System.out.println(testCustomer.statement());
    }
}