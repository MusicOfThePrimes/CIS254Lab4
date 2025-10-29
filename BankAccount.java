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
 * @author Long Him Cheung
 * @since 10-7-2025
 */

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class BankAccount {

    /**
     * Static counter: used to assign a unique, incrementing account number
     * to each new BankAccount instance. Starts from 100000.
     */
    private static int nextAccountNumber = 100000; // Start from this base number

    /**
     * Instance variables:
     * accountNumber: the unique account number assigned to this bank account.
     * balance: the current balance of the bank account.
     * transactions: a StringBuilder used to store the transaction history, 
     *               including timestamps and descriptions.
     */
    private String accountNumber;
    private double balance;
    private StringBuilder transactions;
    
    /**
     * Default constructor:
     * Constructs a new BankAccount with an initial balance of $0.00.
     * Automatically generates a unique account number and starts the 
     * transaction log with the creating entry.
     */
    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.balance = 0.0;
        this.transactions = new StringBuilder();
        logTransaction("Account " + this.accountNumber + " created with balance: $0.00");
    }

    /**
     * Overloaded constructor:
     * Constructs a new BankAccount with the specified initial balance.
     * 
     * If the provided balance is negative, the account is initialized with $0.00,
     * and a transaction log entry is recorded to reflect the adjustment.
     * A unique account number is automatically generated.
     *
     * @param initialBalance the starting balance for the account
     */
    public BankAccount(double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.transactions = new StringBuilder();
        if(initialBalance < 0) {
            this.balance = 0.0;
            logTransaction("Attempted to create account with negative balance. Set to $0.00");
        } else {
            this.balance = initialBalance;
            logTransaction("Account " + this.accountNumber + " created with balance: $" + String.format("%.2f", initialBalance));
        }
    }

    /**
     * Generates a new unique account number using an auto-incrementing counter.
     * The account number is returned as a string, prefixed with "ACCT" followed
     * by a numeric value that increases with each new account.
     * 
     * @return a unique account number as a string
     */
    private String generateAccountNumber() {
        return "ACCT" + (nextAccountNumber++); 
    }

    /**
     * Method to deposit money:
     * Deposits the specified amount into the account.
     * If the amount is less than or equal to zero, the deposit is ignored
     * and a transaction entry is logged indicating the invalid attempt.
     *
     * @param amountIn the amount to deposit (must be positive)
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
     * If the amount is less than or equal to zero, or if there are insufficent funds,
     * the withdrawal is ignored and a transaction entry is logged to indicate the 
     * reason.
     *
     * @param amountOut the amount to withdraw (must be positive and less than or equal 
     *                  to the current balance)
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
     * @return the current account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method: get formatted current balance
     * Returns the formatted current balance of the account.
     *
     * @return the formatted current account balance (e.g., "$50.00")
     */
    public String getFormattedBalance() {
        return String.format("$%.2f", balance);
    }

    /**
     * Getter method: get full transaction history
     * Returns the full transaction history for this account as a string.
     *
     * @return a string representing the complete transaction statement
     */
    public String getStatement() {
        return transactions.toString();
    }

    /**
     * Getter method: get account number 
     * Returns the unique account number assigned to this account.
     *
     * @return the account number as a string
     */
    public String getAccountNumber() {
        return accountNumber;
    } 

    /**
     * Helper method: log transaction with timestamp
     * Appends a timestamped message to the transaction history.
     * The timestamp follows the yyyy-MM-dd HH:mm:ss format
     * 
     * @param message the transaction message to log
     */
    private void logTransaction(String message) {
        Calendar now = Calendar.getInstance();

        // timestamp format: yyyy-MM-dd HH:mm:ss  Comment: timestamp are same for test due to operations run extremely fast
        // String timestamp = String.format("%1$tF %1$tT", now);  
        
        // timestamp format (including milliseconds)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
        String timestamp = sdf.format(now.getTime());  
        transactions.append("[").append(timestamp).append("] ").append(message).append("\n");
    }
}
