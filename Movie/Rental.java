public class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }


    double computeRentalPrice(double rentalPrice) {
        rentalPrice =0;
        if (_movie instanceof regularMovieRental) {
            rentalPrice += 2;
            if (getDaysRented() > 2) {
                rentalPrice += (getDaysRented() - 2) * _movie.getPriceCode();
            }
        }

        if (_movie instanceof newReleaseMovieRental) {
            rentalPrice += getDaysRented() * _movie.getPriceCode();
        }

        if (_movie instanceof childrenMovieRental) {
            rentalPrice += 1.5;
            if (getDaysRented() > 3 ) {
                rentalPrice += (getDaysRented() - 3) * _movie.getPriceCode();
            }
        }
        return rentalPrice;
    }

    int computeFrequentRenterPoints(Customer customer) {
        // add frequent renter points
        customer.frequentRenterPoints++;

        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (getDaysRented() > 1)) {
            customer.frequentRenterPoints++;
        }
        return customer.frequentRenterPoints;
    }
}