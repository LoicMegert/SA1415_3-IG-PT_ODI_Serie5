package ch.hearc.ig.odi.customeraccount.app;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 *
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Application {
    
    public static void main(String[] args) {
        try {
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
                ex.printStackTrace();
            }
            
            try {
                myFirstAccount.debit(2 * myFirstAccount.getBalance());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            try {
                Account.transfer(0, myFirstAccount, mySecondAccount);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            System.out.println();
            System.out.println("Test de la classe Bank");
            System.out.println();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
