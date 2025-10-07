/**
 * This BankAccount class represents a simple bank account with basic
 * operations such as deposit, withdraw, and statement tracking.
 * <p>
 * Each account has a unique account number, a current balance, and a transaction
 * history. Transactions are timestamped using java.util.Calendar.
 * </p>
 *
 * <p>Features:</p>
 * <ul>
 *   <li>Auto-incremented account number</li>
 *   <li>Balance management with validation</li>
 *   <li>Transaction log using StringBuilder</li>
 *   <li>Timestamps for every transaction</li>
 * </ul>
 *
 * <p>This class is designed to be used with an external application tester.</p>
 *
 * @author Huilin Reid
 * @author Lab 4 Partner
 * @since 10-7-2025
 */

import java.util.Calendar;

public class BankAccount {

    /**
     * Static counter to generate unique account numbers.
     */
    private static int nextAccountNumber = 100000; // Start from this base number

    /**
     * Instance variables:
     * accountNumber: the unique account number of this bank account.
     * balance: the current balance of the bank account.
     * transactions: a StringBuilder used to store the transaction history.
     */
    private String accountNumber;
    private double balance;
    private StringBuilder transactions;
    
    /**
     * Default constructor:
     * Constructs a new BankAccount with a balance of $0.00.
     * Initializes a unique account number and starts the transaction log.
     */
    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        this.transactions = new StringBuilder();
        logTransaction("Account created with balance: $0.00");
    }

    /**
     * Overloaded constructor:
     * Constructs a new BankAccount with the specified initial balance.
     * If the initial balance is negative, it will default to $0.00.
     *
     * @param initialBalance the initial amount to deposit into the account
     */
    public BankAccount(double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.transactions = new StringBuilder();
        if(initialBalance < 0) {
            this.balance = 0.0;
            logTransaction("Attempted to create account with negative balance. Set to $0.00");
        } else {
            this.balance = initialBalance;
            logTransaction("Account created with balance: $" + String.format("%.2f", initialBalance));
        }
    }

    /**
     * Generates a new unique incrementing account number
     * using an auto-incremented counter.
     *
     * @return the generated account number as a string
     */
    private String generateAccountNumber() {
        return "ACCT" + (nextAccountNumber++); 
    }

    /**
     * Method to deposit money:
     * Deposits the specified amount into the account.
     * The deposit is ignored if the amount is not positive.
     *
     * @param amountIn the amount to deposit
     */
    public void deposit(double amountIn) {
        if (amountIn <= 0) {
            logTransaction("Attempted to deposit invalid amount: $" + amountIn);
            return;
        }
        balance += amountIn;
        logTransaction("Deposited: $" + String.format("%.2f", amountIn));
    }

    /**
     * Method to withdraw money:
     * Withdraws the specified amount from the account.
     * The withdrawal is ignored if the amount is not positive or if
     * there are insufficient funds.
     *
     * @param amountOut the amount to withdraw
     */
    public void withdraw(double amountOut) {
        if (amountOut <= 0) {
            logTransaction("Attempted to withdraw invalid amount: $" + amountOut);
            return;
        }
        if (amountOut > balance) {
            logTransaction("Attempted to withdraw $" + String.format("%.2f", amountOut) + " but insufficient funds.");
            return;
        }
        balance -= amountOut;
        logTransaction("Withdrew: $" + String.format("%.2f", amountOut));
    }

    /**
     * Getter method: get current balance
     * Returns the current balance of the account.
     *
     * @return the balance as a double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method: get full transaction history
     * Returns the full transaction statement as a string.
     *
     * @return the transaction history
     */
    public String getStatement() {
        return transactions.toString();
    }

    /**
     * Getter method: get account number 
     * Returns the unique account number for this account.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    } 
    
    /**
     * Helper method: log transaction with timestamp
     * Appends a timestamped message to the transaction history.
     *
     * @param message the message to log
     */
    private void logTransaction(String message) {
        Calendar now = Calendar.getInstance();
        String timestamp = String.format("%1$tF %1$tT", now);  // yyyy-MM-dd HH:mm:ss
        transactions.append("[").append(timestamp).append("] ").append(message).append("\n");
    }
}
