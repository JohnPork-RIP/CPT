/**
 * @author: faris
 * date: 09/01/2025
 * my useless app that helps you manage money somehow??
 */

public class money{
    public static void main(String[] args) {
        double expenses = 2300;
        double income = 4000;
        User faris = new User("johnpork", "happyballs1");
        faris.Login("johnpork", "happyballs1");
        faris.ViewProfile();
        faris.addIncome(income);
        faris.addExpense(expenses);
        faris.addIncome(income);
        faris.delIncome(income-2500);
        faris.viewIncome();
        faris.viewExpenses();

    }
}

class User extends Account{
    
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void Login(String username, String password){
        if (this.username == username && this.password == password){
            access = true;
            System.out.println("You have logged in");
        }else{
            access = false;
            System.out.println("username and/or password is incorrect");
        }

    }

    public void ViewProfile(){
        if (access == true){
            System.out.printf("username: %s\n", username);
            System.out.printf("password: %s\n", password);
        }else{
            System.out.println("you do not have access to this user");
        }
    }
}

class Account{
    protected boolean access;
    private double income;
    private double expenses;
    private double balance;

    public Account() {
        access = false;
    }

    public void checkBalance(){
        balance = income - expenses;
        if (balance == 0){
            System.out.println("UR BROKE U NEEDA MAKE MONEY");
        }else if(balance < 0){
            System.out.println("UR IN DEBT BROTHER LOCK IN");
        }
    }

    public void addIncome(double income){
        this.income += income;
        checkBalance();
        viewBalance();
        Db.addTransaction(null);
    }

    public void addExpense(double expense){
        this.expenses += expense;
        checkBalance();
        viewBalance();
    }

    public void delIncome(double income){
        this.income -= income;
        checkBalance();
        viewBalance();
    }

    public void delExpense(double expense){
        this.expenses -= expense;
        checkBalance();
        viewBalance();
    }

    public void viewBalance(){
        System.out.printf("Balance: %f\n", balance);
    }

    public void viewIncome(){
        System.out.printf("Income: %f\n", income);
    }

    public void viewExpenses(){
        System.out.printf("Expenses: %f\n", expenses);
    }
}

class Transaction{
    private double amount;
    private String category;
    private String date;

    public Transaction() {
        // ...amount
        Db.addTransaction(this);
    }
}