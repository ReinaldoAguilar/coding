package org.fundacionjala.coding.reinaldoA.movies;

/**
 * Created by reinaldo on 11/03/2017.
 */
class Rental {
    private Movie movie;
    private int daysRented;

    /**
     * @param movie      Movie.
     * @param daysRented DaysRented.
     */
    public Rental(final Movie movie, final int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /**
     * @return the daysRented.
     */
    public int getDaysRented() {
        return daysRented;
    }

    /**
     * @return movie object.
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * @return price object.
     */
    public double eachMethod() {
        return getMovie().thisAmount(this.daysRented);
    }

    /**
     * @return getFrequentRenterPoint int.
     */
    public int getFrequentRenterPoint() {
        return ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                &&
                getDaysRented() > 1) ? 2 : 1;
    }
}
