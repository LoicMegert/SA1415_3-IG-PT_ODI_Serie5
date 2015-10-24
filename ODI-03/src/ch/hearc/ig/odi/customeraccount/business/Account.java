package ch.hearc.ig.odi.customeraccount.business;

/**
 * Classe permettant la gestion de comptes.
 * 
 * @author Loïc Megert <loic.megert@he-arc.ch>
 */
public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.customer.getFirstName());
        sb.append(" ");
        sb.append(this.customer.getLastName());
        sb.append(";");
        sb.append(this.number);
        sb.append(";");
        sb.append(this.name);
        sb.append(";");
        sb.append(this.balance);
        sb.append(";");
        sb.append(this.rate);
        return sb.toString();
    }

    /**
     * Constructeur paramétré pour les comptes.
     *
     * @param number Le numéro du compte.
     * @param name Le nom du compte.
     * @param rate Le taux d'intérêt du compte.
     * @param customer Le propriétaire du compte.
     */
    public Account(final String number, final String name, final double rate, final Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    /**
     * Crédite le montant désiré sur le compte.
     *
     * @param amount Le montant à créditer.
     */
    public void credit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de créditer un montant négatif ou null !");
        }
        this.balance += amount;
    }

    /**
     * Débite le montant désiré sur le compte.
     *
     * @param amount Le montant à débiter.
     */
    public void debit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de débiter un montant négatif ou null !");
        }
        if (this.balance < amount) {
            throw new IllegalStateException("Solde insuffisant ! Débit refusé.");
        }
        this.balance -= amount;
    }

    /**
     * Transfère le montant désiré du compte source au compte cible.
     *
     * @param amount Le montant à transférer.
     * @param source Le compte source.
     * @param target Le compte cible.
     */
    public static void transfer(final double amount, final Account source, final Account target) {
        source.debit(amount);
        target.credit(amount);
    }

}
