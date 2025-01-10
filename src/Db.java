public final class Db {
    private static Transaction[] transactions = new Transaction[100];

    public static void addTransaction(Transaction t) {
        transactions[0] = t;
    }
}
