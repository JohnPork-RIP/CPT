/**
 * @author: Faris
 * @date: 09/01/2025
 * app that somehwo helps u make moenye
 */
public class money {
    /**
     * The main method to run the application.
     * 
     * @param args Command-line arguments (not used).
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        double expenses = 2300;
        double income = 4000;
        User faris = new User("johnpork", "happyballs1");
        Transaction t1 = new Transaction(1500.75, "payment", "10/01/2025");
        Transaction t2 = new Transaction(24500.50, "deposit", "11/10/2025");
        Transaction t3 = new Transaction(785.99, "withdrawal", "07/15/2025");
        Transaction t4 = new Transaction(320.00, "purchase", "09/25/2025");
        Transaction t5 = new Transaction(1900.30, "transfer", "03/12/2025");
        Transaction t6 = new Transaction(11000.40, "loan", "01/10/2025");
        Transaction t7 = new Transaction(800.20, "refund", "02/22/2025");
        Transaction t8 = new Transaction(500.50, "gift", "08/09/2025");
        Transaction t9 = new Transaction(120.60, "subscription", "06/17/2025");
        Transaction t10 = new Transaction(2500.90, "savings", "05/05/2025");

        faris.Login("johnpork", "happyballs1");
        faris.ViewProfile();
        faris.addIncome(income);
        faris.addExpense(expenses);
        faris.addIncome(income);
        faris.delIncome(income - 2500);
        faris.viewIncome();
        faris.viewExpenses();
        Db.findTransaction();
    }
}

/**
 * The User class represents a user in the system, inheriting from the Account class.
 */
class User extends Account {
    
    private String username;
    private String password;

    /**
     * Constructs a User with a username and password.
     * 
     * @param username The user's username.
     * @param password The user's password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Logs the user into the system.
     * 
     * @param username The input username.
     * @param password The input password.
     */
    public void Login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            access = true;
            System.out.println("You have logged in");
        } else {
            access = false;
            System.out.println("Username and/or password is incorrect");
        }
    }

    /**
     * Displays the user's profile if they have access.
     */
    public void ViewProfile() {
        if (access) {
            System.out.printf("Username: %s\n", username);
            System.out.printf("Password: %s\n", password);
        } else {
            System.out.println("You do not have access to this user");
        }
    }
}

/**
 * The Account class represents a basic account with income, expenses, and balance tracking.
 */
class Account {
    protected boolean access;
    private double income;
    private double expenses;
    private double balance;

    /**
     * Constructs an Account with default values.
     */
    public Account() {
        access = false;
    }

    /**
     * Checks the current balance and prints messages based on the balance value.
     */
    public void checkBalance() {
        balance = income - expenses;
        if (balance == 0) {
            System.out.println("You're broke! You need to make money.");
        } else if (balance < 0) {
            System.out.println("You're in debt! Time to lock in.");
        }
    }

    /**
     * Adds income to the account.
     * 
     * @param income The amount of income to add.
     */
    public void addIncome(double income) {
        this.income += income;
        checkBalance();
        viewBalance();
    }

    /**
     * Adds an expense to the account.
     * 
     * @param expense The amount of expense to add.
     */
    public void addExpense(double expense) {
        this.expenses += expense;
        checkBalance();
        viewBalance();
    }

    /**
     * Deletes a portion of the income from the account.
     * 
     * @param income The amount of income to delete.
     */
    public void delIncome(double income) {
        this.income -= income;
        checkBalance();
        viewBalance();
    }

    /**
     * Deletes a portion of the expenses from the account.
     * 
     * @param expense The amount of expense to delete.
     */
    public void delExpense(double expense) {
        this.expenses -= expense;
        checkBalance();
        viewBalance();
    }

    /**
     * Displays the current balance.
     */
    public void viewBalance() {
        System.out.printf("Balance: %f\n", balance);
    }

    /**
     * Displays the current income.
     */
    public void viewIncome() {
        System.out.printf("Income: %f\n", income);
    }

    /**
     * Displays the current expenses.
     */
    public void viewExpenses() {
        System.out.printf("Expenses: %f\n", expenses);
    }
}

/**
 * The Transaction class represents a financial transaction with an amount, category, and date.
 */
class Transaction {
    private double amount;
    private String category;
    private String date;

    /**
     * Constructs a Transaction with an amount, category, and date.
     * 
     * @param amount   The amount of the transaction.
     * @param category The category of the transaction (e.g., payment, deposit, withdrawal).
     * @param date     The date of the transaction.
     */
    public Transaction(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        Db.addTransaction(this);
    }

    /**
     * Retrieves the amount of the transaction.
     * 
     * @return The amount of the transaction.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Retrieves the category of the transaction.
     * 
     * @return The category of the transaction.
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * Retrieves the date of the transaction.
     * 
     * @return The date of the transaction.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Returns a string representation of the transaction details.
     * 
     * @return A string describing the transaction.
     */
    @Override
    public String toString() {
        return "Amount: " + this.amount + "\n" +
               "Category: " + this.category + "\n" +
               "Date: " + this.date;
    }
}