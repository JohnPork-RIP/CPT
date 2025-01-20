
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public final class Db {

    /**
     * The main method initializes some sample transactions and prints them to the console.
     * @param args Command-line arguments (not used).
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Transaction t1 = new Transaction(1500.75, "payment", "10/01/2025");
        Transaction t2 = new Transaction(24500.50, "deposit", "11/10/2025");
        Transaction t3 = new Transaction(785.99, "withdrawal", "07/15/2025");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    /**
     * A list to store all transactions.
     */
    protected static ArrayList<Transaction> transactions = new ArrayList<>();

    /**
     * Adds a transaction to the list.
     * @param t The transaction to add.
     */
    public static void addTransaction(Transaction t) {
        transactions.add(t);
    }

    /**
     * Searches for a transaction by amount using binary search.
     * @param x The list of transactions to search.
     * @param a The amount to search for.
     * @return The index of the transaction if found, otherwise -1.
     */
    public static int searchTransactionA(ArrayList<Transaction> x, Double a) {
        x.sort(Comparator.comparingDouble(Transaction::getAmount));
        int low = 0;
        int high = x.size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (x.get(middle).getAmount() == a) {
                return middle;
            } else if (x.get(middle).getAmount() < a) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Searches for a transaction by category using binary search.
     * @param x The list of transactions to search.
     * @param c The category to search for.
     * @return The index of the transaction if found, otherwise -1.
     */
    public static int searchTransactionC(ArrayList<Transaction> x, String c) {
        x.sort(Comparator.comparing(Transaction::getCategory));

        int low = 0;
        int high = x.size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            Transaction mid = x.get(middle);
            int compare = mid.getCategory().compareTo(c);
            if (compare == 0) {
                return middle;
            } else if (compare < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Searches for a transaction by date using binary search.
     * @param x The list of transactions to search.
     * @param c The date to search for.
     * @return The index of the transaction if found, otherwise -1.
     */
    public static int searchTransactionD(ArrayList<Transaction> x, String c) {
        x.sort(Comparator.comparing(Transaction::getDate));

        int low = 0;
        int high = x.size() - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            Transaction mid = x.get(middle);
            int compare = mid.getDate().compareTo(c);
            if (compare == 0) {
                return middle;
            } else if (compare < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * Prompts the user to search for a transaction by amount, category, or date.
     */
    public static void findTransaction() {
        Scanner input = new Scanner(System.in);
        System.out.println("a: amount - c:category - d:date - what do you want to search by? ");
        String x = input.nextLine();

        if (x.charAt(0) == 'a') {
            System.out.println("Enter amount: ");
            double y = input.nextDouble();

            int z = searchTransactionA(transactions, y);

            if (z == -1) {
                System.out.println("Transaction not found.");
            } else {
                System.out.println(transactions.get(z).toString());
            }
        } else if (x.charAt(0) == 'c') {
            System.out.println("Enter category: ");
            String y = input.nextLine();

            int z = searchTransactionC(transactions, y);

            if (z == -1) {
                System.out.println("Transaction not found.");
            } else {
                System.out.println(transactions.get(z).toString());
            }
        } else if (x.charAt(0) == 'd') {
            System.out.println("Enter date: ");
            String y = input.nextLine();

            int z = searchTransactionD(transactions, y);

            if (z == -1) {
                System.out.println("Transaction not found.");
            } else {
                System.out.println(transactions.get(z).toString());
            }
        } else {
            System.out.println("Enter a letter from the selection.");
            x = input.nextLine();
        }

        input.close();
    }

}

