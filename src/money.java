/**
 * @author: faris
 * date: 09/01/2025
 * my useless app that helps you manage money somehow??
 */

public class money{
    public static void main(String[] args) {
        User faris = new User("johnpork", "happyballs1");
        faris.Login("johnpork", "happyballs1");
        faris.ViewProfile();
    }
}

class User{
    private boolean access;
    private String username;
    private String password;
    private Account account;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.account = new Account();
        access = false;
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
    private double income;
    private double expense;
    private double balance;
}

class Transaction{
    private double amount;
    private String category;
    private String date;
}