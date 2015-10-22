package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

/**
 *
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Customer {

    private Collection<Account> accounts;
    private int number;
    private String firstName;
    private String lastName;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number);
        sb.append(";");
        sb.append(this.firstName);
        sb.append(";");
        sb.append(this.lastName);
        sb.append(";");
        sb.append(this.accounts.toString());
        return sb.toString();
    }
    
    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer(final Integer number, final String firstName, final String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList();
    }

    /**
     *
     * @param number
     */
    public Account getAccountByNumber(final String number) {
        for (Account account : this.accounts) {
            if (number == account.getNumber()) {
                return account;
            }
        }
        return null;
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     */
    public void addAccount(final String number, final String name, final double rate) {
        this.accounts.add(new Account(number, name, rate, this));
    }

}
