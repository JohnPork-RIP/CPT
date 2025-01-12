import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public final class Db {
    public static void main(String[] args) {
        Transaction t1 = new Transaction(1500.75, "payment", "10/01/2025");
        Transaction t2 = new Transaction(24500.50, "deposit", "11/10/2025");
        Transaction t3 = new Transaction(785.99, "withdrawal", "07/15/2025");
        addTransaction(t1);
        addTransaction(t2);
        addTransaction(t3);
        System.out.println(transactions.length);
    }
    protected static Transaction[] transactions = {};

    public static void addTransaction(Transaction t) {
        ArrayList<Transaction> list = new ArrayList<Transaction>(Arrays.asList(transactions));
        list.add(t);
        transactions = list.toArray(new Transaction[list.size()]);
    }

    public static int searchTransactionA(Transaction[] x, Double a){
        int low = 0;
        int high = x.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x[middle].getAmount() == a) {
                return middle;
            } else if (x[middle].getAmount() < a) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int searchTransactionCD(Transaction[] x, String c){
        int low = 0;
        int high = x.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x[middle].getCategory().compareTo(c) == 0) {
                return middle;
            } else if (x[middle].getCategory().compareTo(c) < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void findTransaction(){
        Scanner input = new Scanner(System.in);
        System.out.println("a: amount - c:category - d:date - what do you want to search by? ");
        String x = input.nextLine();


        if (x.charAt(0) == 'a'){
            System.out.println("Enter amount: ");
            double y = input.nextDouble();

            int z = searchTransactionA(transactions, y);

            if (z == -1){
                System.out.println("Transaction not found.");
            }else{
                System.out.println(transactions[z]);
            }
        }else if (x.charAt(0) == 'c'){
            System.out.println("Enter category: ");
            String y = input.nextLine();

            int z = searchTransactionCD(transactions, y);

            if (z == -1){
                System.out.println("Transaction not found.");
            }else{
                System.out.println(transactions[z]);
            }
        }else if (x.charAt(0) == 'd'){
            System.out.println("Enter date: ");
            String y = input.nextLine();

            int z = searchTransactionCD(transactions, y);

            if (z == -1){
                System.out.println("Transaction not found.");
            }else{
                System.out.println(transactions[z]);
            }
        }else{
            System.out.println("Enter a letter from the selection.");
        }

        input.close();
    }     
}
