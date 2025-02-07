package encapsulation;

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Aryan",0);

        System.out.println(acc1.getBalance());
        acc1.deposit(1000);
        System.out.println(acc1.getBalance());
        acc1.withdraw(79);
        System.out.println(acc1.getBalance());
    }
}
