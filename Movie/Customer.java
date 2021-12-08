import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    protected int frequentRenterPoints;
    private String _name;
    private Vector _rentals = new Vector();

    public Customer (String name, int frequentRenterPoints) {
        this._name = name;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public void addRental(Rental rental) {
        _rentals.addElement(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement() {

        double      totalPrice          = 0;
        Enumeration rentals              = _rentals.elements();
        String      statement               = "Rental Record for: "+ getName() + "\n";

        while (rentals.hasMoreElements()) {

            double rentalPrice = 0;
            Rental rental       = (Rental) rentals.nextElement();

            // determine amounts for rental line
            rentalPrice = rental.computeRentalPrice(rentalPrice);
            frequentRenterPoints = rental.computeFrequentRenterPoints(this);

            // show figures for this rental
            statement += "<customerName> " + getName() + " </customerName>," +"\t<movie> " + rental.getMovie().getTitle() +
                    " </movie>,<moviePrice> " + String.valueOf(rentalPrice) + " </moviePrice> \n";
            totalPrice += rentalPrice;
        }
        statement = addFooter(totalPrice, statement);

        return statement;
    }

    private String addFooter(double totalPrice, String statement) {
        // add footer lines
        statement += "Amount owed is: $" + String.valueOf(totalPrice) + "\n";
        statement += "You earned " + String.valueOf(frequentRenterPoints) +
                " frequent renter points";
        return statement;
    }

}