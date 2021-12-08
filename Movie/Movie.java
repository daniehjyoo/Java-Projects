public class Movie {

    public static final int CHILDREN   = 2;
    public static final int REGULAR 	= 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private double _priceCode;

    public Movie(String title, double priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public double getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }
}