import java.util.ArrayList;
import java.util.Collections;

/**
 * This sample is a BankAccount class that implements Comparable (with generics) and
 * Measurable and calls Collections.sort and Measurable.average on list of accounts.
 */
public class BankAccount implements Comparable<BankAccount>, Measurable{
    public float balance;
    public float rate;
    public int id;
    public static int nextId=1000;

    public BankAccount(float balance, float rate) {
        this.balance=balance;
        this.rate=rate;
        this.id=nextId;
        nextId++;
    }
    public void processYear() {
        float interest = balance * rate;
        balance = balance + interest;

    }
    public void processNYears(int n) {
        int i = 0;
        while (i < n) {
            processYear();
            i = i + 1;
        }
    }
    @Override
    public float getMeasure() {
        return balance;
    }
    @Override
    public String toString() {
        return "balance:"+balance;
    }

    @Override
    public int compareTo(BankAccount other) {

        if (this.balance>other.balance) {
            return 1;
        } else if (this.balance<other.balance) {
            return -1;
        } else {
            return 0;
        }
    }


    public static void main(String [] args) {

        BankAccount account = new BankAccount(1000f,.1f);

        account.processNYears(4);
        System.out.println("balance after two years is: " + account.balance);
        BankAccount account2 = new BankAccount(1900,.1f);
        if (account2.compareTo(account)>0) {
            System.out.println("account2 bigger");
        }
        BankAccount account3 = new BankAccount(1200,.1f);
        // type of list can be BankAccount because sort and average both accept
        // variable type of any subclass/implementer of Comparable or Measurable (respectively)
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        accounts.add(account);
        accounts.add(account2);
        accounts.add(account3);
        System.out.println(accounts);
        Collections.sort(accounts);
        System.out.println(accounts);

        System.out.println("the average is:"+Measurable.average(accounts));



    }
}
