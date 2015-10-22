package ch.hearc.ig.odi.customeraccount.business;

import java.util.*;

/**
 * Classe permettant la gestion de clients.
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
     * Constructeur paramétré pour les clients.
     *
     * @param number Le numéro du client.
     * @param firstName Le prénom du client.
     * @param lastName Le nom du client.
     */
    public Customer(final Integer number, final String firstName, final String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList();
    }

    /**
     * Retourne le compte possédant le numéro passé en paramètre.
     *
     * @param number Le numéro du compte désiré.
     */
    public Account getAccountByNumber(final String number) {
        Account account = null;
        
        for (Account acc : this.accounts) {
            if (number.equals(account.getNumber())) {
                account = acc;
                break;
            }
        }
        
        return account;
    }

    /**
     * Ajoute un compte à la liste des comptes du client.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     */
    public void addAccount(final String number, final String name, final double rate) {
        this.accounts.add(new Account(number, name, rate, this));
    }

}
