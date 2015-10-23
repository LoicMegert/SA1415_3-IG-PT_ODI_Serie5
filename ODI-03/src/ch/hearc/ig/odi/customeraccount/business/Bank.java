package ch.hearc.ig.odi.customeraccount.business;

import java.util.ArrayList;
import java.util.Collection;

public class Bank {

    private int number;
    private String name;
    private Collection<Customer> customers;
    private Collection<Account> accounts;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Constructeur paramétré pour les banques.
     *
     * @param number Le numero de la banque.
     * @param name Le nom de la banque.
     */
    public Bank(final int number, final String name) {
        this.number = number;
        this.name = name;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    /**
     * Cherche le compte ayant le numero donné.
     *
     * @param number Le numero du compte désiré.
     * @return Le compte recherché ou null s'il n'existe pas.
     */
    public Account getAccountByNumber(final String number) {
        Account account = null;

        for (Account acc : accounts) {
            if (acc.getNumber().equals(number)) {
                account = acc;
                break;
            }
        }

        return account;
    }

    /**
     * Recherche le client ayant le numero donné.
     * 
     * @param number Le numero du client désiré.
     * @return Le client recherché ou null s'il n'existe pas.
     */
    public Customer getCustomerByNumber(final int number) {
        Customer customer = null;

        for (Customer cust : customers) {
            if (cust.getNumber() == number) {
                customer = cust;
                break;
            }
        }

        return customer;
    }

    /**
     * Ajoute un client à la banque.
     * 
     * @param number Le numero du nouveau client.
     * @param firstName Le prénom du nouveau client.
     * @param lastName Le nom du nouveau du client.
     */
    public void addCustomer(final int number, final String firstName, final String lastName) {
        customers.add(new Customer(number, firstName, lastName));
    }

    /**
     * Ajoute un compte à la banque.
     * 
     * @param number Le numero du nouveau compte.
     * @param name Le nom du nouveau compte.
     * @param rate Le taux du nouveau compte.
     * @param customer Le possesseur du compte.
     */
    public void addAccount(final String number, final String name, final double rate, final Customer customer) {
        if(getCustomerByNumber(customer.getNumber()) == null) {
            throw new IllegalArgumentException("Le client n'est pas enregistré au près de la banque.");
        }
        
        accounts.add(new Account(number, name, rate, customer));
    }

}
