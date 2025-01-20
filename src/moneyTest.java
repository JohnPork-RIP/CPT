import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Faris
 * @date 09/01/2025
 * testin app that helps u stack yo bread 
 */
 
public class moneyTest {

    @Test
    void testAddIncome() {
        Account account = new Account();
        account.addIncome(5000);
        assertEquals(5000, account.viewIncome());
        assertEquals(5000, account.viewBalance());
    }

    @Test
    void testAddExpense() {
        Account account = new Account();
        account.addIncome(5000);
        account.addExpense(2000);
        assertEquals(2000, account.viewExpenses());
        assertEquals(3000, account.viewBalance());
    }

    @Test
    void testDelIncome() {
        Account account = new Account();
        account.addIncome(5000);
        account.delIncome(2000);
        assertEquals(3000, account.viewIncome());
        assertEquals(3000, account.viewBalance());
    }

    @Test
    void testDelExpense() {
        Account account = new Account();
        account.addExpense(2000);
        account.delExpense(500);
        assertEquals(1500, account.viewExpenses());
        assertEquals(-1500, account.viewBalance());
    }

    @Test
    void testViewBalance() {
        Account account = new Account();
        account.addIncome(4000);
        account.addExpense(2500);
        assertEquals(1500, account.viewBalance());
    }

    @Test
    void testViewIncome() {
        Account account = new Account();
        account.addIncome(4000);
        assertEquals(4000, account.viewIncome());
    }

    @Test
    void testViewExpenses() {
        Account account = new Account();
        account.addExpense(2500);
        assertEquals(2500, account.viewExpenses());
    }

    @Test
    void testCheckBalance() {
        Account account = new Account();
        account.addIncome(2000);
        account.addExpense(2000);
        assertEquals(0, account.viewBalance()); 
    }

    @Test
    void testLoginSuccess() {
        User user = new User("testuser", "password123");
        user.Login("testuser", "password123");
        assertTrue(user.access);
    }

    @Test
    void testLoginFailure() {
        User user = new User("testuser", "password123");
        user.Login("wronguser", "wrongpassword");
        assertFalse(user.access);
    }

    @Test
    void testViewProfileWithAccess() {
        User user = new User("testuser", "password123");
        user.Login("testuser", "password123");
        assertEquals("Username: testuser\nPassword: password123\n", user.ViewProfile());
    }

    @Test
    void testViewProfileWithoutAccess() {
        User user = new User("testuser", "password123");
        assertEquals("You do not have access to this user\n", user.ViewProfile());
    }

    @Test
    void testTransactionCreation() {
        Transaction transaction = new Transaction(1500.75, "payment", "10/01/2025");
        assertEquals(1500.75, transaction.getAmount());
        assertEquals("payment", transaction.getCategory());
        assertEquals("10/01/2025", transaction.getDate());
    }

    @Test
    void testTransactionToString() {
        Transaction transaction = new Transaction(1500.75, "payment", "10/01/2025");
        assertEquals("Amount: 1500.75\nCategory: payment\nDate: 10/01/2025", transaction.toString());
    }
}
