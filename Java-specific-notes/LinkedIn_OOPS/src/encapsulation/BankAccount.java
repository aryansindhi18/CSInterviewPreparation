package encapsulation;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = Math.max(balance,0);
    }

    public String getName(){
        return this.owner;
    }

    public double getBalance(){
        return this.balance;
    }

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient funds...");
        }
    }

    public void deposit(double amount){
        if(amount > 0)
            balance += amount;
    }
}
