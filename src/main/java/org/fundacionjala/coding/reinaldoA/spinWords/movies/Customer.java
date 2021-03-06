package org.fundacionjala.coding.reinaldoA.spinWords.movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 3/21/2017.
 */
public class Customer {
    private String nameCustomer;
    private List<Rental> rentalsCustomer;

    /**
     * @param nameCustomer String with name of Customer.
     * Constructor of the Customer Class.
     */
    Customer(final String nameCustomer) {
        this.nameCustomer = nameCustomer;
        rentalsCustomer = new ArrayList<>();
    }
    /**
     * Takes a rental, and add to list rental same rental object passed as parameter.
     * @param rental String with rental of movie.
     */
    public void addRental(final Rental rental) {
        rentalsCustomer.add(rental);
    }

    /**
     * @return the nameCustomer string.
     */
    public String getName() {
        return this.nameCustomer;
    }

    /**
     * returns a string generate Detail about retail a movie with respective customer.
     *
     * @return the generateDetail string, but with Rental Record for,Amount owed is,You earned.
     */
    public String generateDetail() {
        StringBuffer result = new StringBuffer();
        result.append("Rental Record for " + getName() + "\n");
        for (Rental rental : rentalsCustomer) {
            result.append("\t" + rental.getMovie().getTitle() + "\t");
            result.append(rental.calculateAmount() + "\n");
        }
        result.append("Amount owed is " + calculateTotalAmount() + "\n");
        result.append("You earned " + calculateTotalFrequentRenterPoints() + " frequent renter points");
        return result.toString();
    }

    /**
     * returns a double Amount owed of retail movie.
     *
     * @return the calculateTotalAmount double.
     */
    public double calculateTotalAmount() {

        return rentalsCustomer.stream()
                .mapToDouble(Rental::calculateAmount)
                .sum();
    }

    /**
     * returns a int Total Frequent Retail Points owed of retail movie.
     *
     * @return the calculateTotalFrequentRenterPoints int.
     */
    public int calculateTotalFrequentRenterPoints() {
        return rentalsCustomer.stream()
                .mapToInt(rental -> rental.calculateFrequentRenterPoint())
                .sum();
    }
}
