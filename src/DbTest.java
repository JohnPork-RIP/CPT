import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
@SuppressWarnings("unused")

/**
 * @author Faris
 * @date 09/01/2025
 * testin the database of the app that helps u stack yo bread 
 */

public class DbTest {

    @Test
    void testAddTransaction() {
        Transaction t1 = new Transaction(1000.0, "payment", "2025-01-01");
        assertTrue(Db.transactions.contains(t1));
    }

    @Test
    void testSearchTransactionA_Found() {
        Transaction t1 = new Transaction(1000.0, "payment", "2025-01-01");
        Transaction t2 = new Transaction(2000.0, "deposit", "2025-01-02");

        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionA(transactions, 1000.0);

        assertEquals(0, index);
        assertEquals(t1, transactions.get(index));
    }

    @Test
    void testSearchTransactionA_NotFound() {
        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionA(transactions, 5000.0);

        assertEquals(-1, index);
    }

    @Test
    void testSearchTransactionC_Found() {
        Transaction t1 = new Transaction(1000.0, "payment", "2025-01-01");
        Transaction t2 = new Transaction(2000.0, "deposit", "2025-01-02");

        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionC(transactions, "deposit");

        assertEquals(0, index);
        assertEquals(t2, transactions.get(index));
    }

    @Test
    void testSearchTransactionC_NotFound() {
        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionC(transactions, "nonexistent");

        assertEquals(-1, index);
    }

    @Test
    void testSearchTransactionD_Found() {
        Transaction t1 = new Transaction(1000.0, "payment", "2025-01-01");
        Transaction t2 = new Transaction(2000.0, "deposit", "2025-01-02");

        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionD(transactions, "2025-01-02");

        assertEquals(1, index);
        assertEquals(t2, transactions.get(index));
    }

    @Test
    void testSearchTransactionD_NotFound() {
        ArrayList<Transaction> transactions = new ArrayList<>(Db.transactions);
        int index = Db.searchTransactionD(transactions, "2025-12-31");

        assertEquals(-1, index);
    }
}
