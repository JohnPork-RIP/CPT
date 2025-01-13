import java.util.ArrayList;
import java.util.Scanner;

public final class Db {
    public static void main(String[] args) {
        Transaction t1 = new Transaction(1500.75, "payment", "10/01/2025");
        Transaction t2 = new Transaction(24500.50, "deposit", "11/10/2025");
        Transaction t3 = new Transaction(785.99, "withdrawal", "07/15/2025");

        for (Transaction string : transactions) {
            System.out.println(string);
        }
        
    }
    protected static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public static void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public static int searchTransactionA(ArrayList<Transaction> x, Double a){
        int low = 0;
        int high = x.size() - 1;  // size

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x.get(middle).getAmount() == a) {  // x.get(middle)
                return middle;
            } else if (x.get(middle).getAmount() < a) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int searchTransactionC(ArrayList<Transaction> x, String c){
        int low = 0;
        int high = x.size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x.get(middle).getCategory().compareTo(c) == 0) {
                return middle;
            } else if (x.get(middle).getCategory().compareTo(c) < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int searchTransactionD(ArrayList<Transaction> x, String c){
        int low = 0;
        int high = x.size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x.get(middle).getDate().compareTo(c) == 0) {
                return middle;
            } else if (x.get(middle).getDate().compareTo(c) < 0) {
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
                System.out.println(transactions.get(z));
            }
        }else if (x.charAt(0) == 'c'){
            System.out.println("Enter category: ");
            String y = input.nextLine();

            int z = searchTransactionC(transactions, y);

            if (z == -1){
                System.out.println("Transaction not found.");
            }else{
                System.out.println(transactions.get(z));
            }
        }else if (x.charAt(0) == 'd'){
            System.out.println("Enter date: ");
            String y = input.nextLine();

            int z = searchTransactionD(transactions, y);

            if (z == -1){
                System.out.println("Transaction not found.");
            }else{
                System.out.println(transactions.get(z));
            }
        }else{
            System.out.println("Enter a letter from the selection.");
        }

        input.close();
    }     
}
