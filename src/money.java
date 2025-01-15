
/**
 * @author: faris
 * date: 09/01/2025
 * my useless app that helps you manage money somehow??
 */

public class money{
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
        Transaction t10 = new Transaction(2500.90, "savings", "05/05/2025"); // ai im lazy

        faris.Login("johnpork", "happyballs1");
        faris.ViewProfile();
        faris.addIncome(income);
        faris.addExpense(expenses);
        faris.addIncome(income);
        faris.delIncome(income-2500);
        faris.viewIncome();
        faris.viewExpenses();
        Db.findTransaction();
        
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
    }

    public void addExpense(double expense){
        this.expenses += expense;
        checkBalance();
    }

    public void delIncome(double income){
        this.income -= income;
        checkBalance();
    }

    public void delExpense(double expense){
        this.expenses -= expense;
        checkBalance();
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

class Transaction {
    private double amount;
    private String category;
    private String date;

    public Transaction(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        Db.addTransaction(this);
    }


    public double getAmount(){
        return this.amount;
    }
    
    public String getCategory(){
        return this.category;
    }

    public String getDate(){
        return this.date;
    }

    public boolean isEqual(Transaction t){
        if (this.amount == t.amount && this.category.equals(t.category) && this.date.equals(t.date)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public String toString(){
        return "Amount: "+this.amount+"\n"+"Category: "+this.category+"\n"+"Date: "+date;
    }
}
