/**
 * Bank Account Application Tester
 * @author Hellen Pacheco
 */
public class Application {

    public static void main(String[] args) {

        // int option = 0;
        // double amount = 0.0;
        BankAccount account = new BankAccount(100);
        System.out.println("New Account Balance: " + account.getBalance());
        System.out.println("Withdrawing 200");
        account.withdraw(200);
        System.out.println("New Balance: " + account.getBalance());
        System.out.println("Withdrawing -100");
        account.withdraw(-100);
        System.out.println("New Balance: " + account.getBalance());
        System.out.println("Depositing -100");
        account.deposit(-100);
        System.out.println("New Balance: " + account.getBalance());
        System.out.println("Depositing 1000");
        account.deposit(1000);
        System.out.println("New Balance: " + account.getBalance());  // print balance
        System.out.println("Withdrawing 200");
        account.withdraw(200);
        System.out.println("New Balance: " + account.getBalance());  // print balance
        System.out.println("*************************************");
        System.out.println(account.getStatement());

        BankAccount account2 = new BankAccount(50);  // bank account 2
        BankAccount account3 = new BankAccount(150);  // bank account 3
        BankAccount account4 = new BankAccount();  // bank account 4
        System.out.println("Account 1 Number: " + account.getAccountNumber() + "   Balance: " + account.getBalance());  // print account 1
        System.out.println("Account 2 Number: " + account2.getAccountNumber() + "   Balance: " + account2.getBalance());  // print account 2
        System.out.println("Account 3 Number: " + account3.getAccountNumber() + "   Balance: " + account3.getBalance());  // print account 3
        System.out.println("Account 4 Number: " + account4.getAccountNumber() + "   Balance: " + account4.getBalance());  // print account 4
    }

}
