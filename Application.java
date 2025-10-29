/**
 * Bank Account Application Tester
 * @author Hellen Pacheco
 */
public class Application {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(100);
        System.out.println("\nNew account " + account.getAccountNumber() + 
                           " created with balance: " + account.getBalance());
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

        // System.out.println("*************************************");

        System.out.println("\nAccount statements:");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(account.getStatement());
    
        System.out.println("Account balance: " + account.getBalance());  // print account balance

        // System.out.println("\nMore Accounts, Balance, Statements:");
        System.out.println("\n***************************************************************************");
        BankAccount account2 = new BankAccount(50);  // bank account 2
        System.out.println("Account " + account2.getAccountNumber() + "\nBalance: " + account2.getBalance());  // print account 2
        System.out.println("Statements:\n" + account2.getStatement());  // print statements

        BankAccount account3 = new BankAccount(150);  // bank account 3
        System.out.println("Account " + account3.getAccountNumber() + "\nBalance: " + account3.getBalance());  // print account 3
        System.out.println("Statements:\n" + account3.getStatement());  // print statements

        BankAccount account4 = new BankAccount();  // bank account 4 
        System.out.println("Account " + account4.getAccountNumber() + "\nBalance: " + account4.getFormattedBalance());  // print account 4
        System.out.println("Statements:\n" + account4.getStatement());
        
        account4.withdraw(50);
        account4.deposit(-100);
        account4.deposit(888.88);

        System.out.println("\nBalance: " + account4.getFormattedBalance());  // print account balance, formatted 
        System.out.println("Statements:\n" + account4.getStatement());
    }
}
