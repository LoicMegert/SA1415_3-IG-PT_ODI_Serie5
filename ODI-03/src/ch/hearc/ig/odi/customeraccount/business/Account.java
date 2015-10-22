package ch.hearc.ig.odi.customeraccount.business;

/**
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
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public Account(final String number, final String name, final double rate, final Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    /**
     *
     * @param amount
     */
    public void credit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        this.balance += amount;
    }

    /**
     *
     * @param amount
     */
    public void debit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        if (this.balance < amount) {
            throw new IllegalStateException();
        }
        this.balance -= amount;
    }

    /**
     *
     * @param amount
     * @param source
     * @param target
     */
    public static void transfer(final double amount, final Account source, final Account target) {
        source.debit(amount);
        target.credit(amount);
    }

}
