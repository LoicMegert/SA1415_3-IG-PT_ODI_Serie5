package ch.hearc.ig.odi.customeraccount.app;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Bank;
import ch.hearc.ig.odi.customeraccount.business.Customer;
import java.util.Arrays;

/**
 *
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Application {

    public static void main(String[] args) {
        Customer myCustomer = new Customer(1, "Firstname", "Lastname");

        myCustomer.addAccount("CH-1", "Account#1", 0.03d);
        myCustomer.addAccount("CH-2", "Account#2", 0.01d);

        Account myFirstAccount = myCustomer.getAccountByNumber("CH-1");

        System.out.println("-- Credit function");
        myFirstAccount.credit(1000);
        System.out.println(myFirstAccount.toString());

        System.out.println("-- Debit function");
        myFirstAccount.debit(150);
        System.out.println(myFirstAccount.toString());

        System.out.println("-- Transfer function");
        Account mySecondAccount = myCustomer.getAccountByNumber("CH-2");
        Account.transfer(500, myFirstAccount, mySecondAccount);
        System.out.println(myFirstAccount.toString());
        System.out.println(mySecondAccount.toString());

        System.out.println("-- Test exceptions functions");
        try {
            myFirstAccount.credit(-100);
        } catch (Exception ex) {
            System.out.println(">>> OK");
            System.out.println("    " + ex.getMessage());
            System.out.println("<<<");
        }

        try {
            myFirstAccount.debit(2 * myFirstAccount.getBalance());
        } catch (Exception ex) {
            System.out.println(">>> OK");
            System.out.println("    " + ex.getMessage());
            System.out.println("<<<");
        }

        try {
            Account.transfer(0, myFirstAccount, mySecondAccount);
        } catch (Exception ex) {
            System.out.println(">>> OK");
            System.out.println("    " + ex.getMessage());
            System.out.println("<<<");
        }

        System.out.println();
        System.out.println("-- Test de la classe Bank");
        System.out.println("-- Création d'une banque");
        Bank bank = new Bank(1, "BCN");
        System.out.println(bank.toString());
        
        Customer customer = new Customer(3, "Tic", "Tac");

        System.out.println("-- addCustomer function");
        bank.addCustomer(customer.getNumber(), customer.getFirstName(), customer.getLastName());
        System.out.println(bank.getCustomerByNumber(3).toString());

        System.out.println("-- addAccount function");
        bank.addAccount("CH-3", "Account#3", 2.4, customer);
        System.out.println(bank.getAccountByNumber("CH-3").toString());

        System.out.println("-- Test l'absence d'un client");
        if (bank.getCustomerByNumber(myCustomer.getNumber()) == null) {
            System.out.println(">>> Test OK");
            System.out.println("    Le client " + myCustomer.getFirstName() + " " + myCustomer.getLastName() + " n'est pas enregistré au près de cette banque.");
            System.out.println("<<<");
        } else {
            System.out.println(">>> Test KO");
            System.out.println("    Ce client n'est pas censé être enregistré au près de cette banque.");
            System.out.println("<<<");
        }

        System.out.println("-- addAccount : Test erreur absence du client");
        try {
            bank.addAccount("CH-4", "Account#4", 1.4, myCustomer);
        } catch (Exception ex) {
            System.out.println(">>> OK");
            System.out.println("    " + ex.getMessage());
            System.out.println("<<<");
        }
    }

}
