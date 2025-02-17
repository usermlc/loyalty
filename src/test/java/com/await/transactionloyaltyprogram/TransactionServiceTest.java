package com.await.transactionloyaltyprogram;

import com.await.transactionloyaltyprogram.model.UserAccount;
import com.await.transactionloyaltyprogram.service.TransactionService;
import com.await.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Unit tests for TransactionService class
class TransactionServiceTest {

    // Test case to check if points are correctly added to the user's account
    @Test
    void testEarnPoints() {
        UserAccount user = new UserAccount(1, "Oleksandr", 100);
        TransactionService service = new TransactionService();
        service.earnPoints(user, 50);
        assertEquals(150, user.getBonusPoints()); // Expected balance after earning points
    }

    // Test case to check if spending points works correctly when enough points are available
    @Test
    void testSpendPointsSuccess() {
        UserAccount user = new UserAccount(1, "Oleksandr", 100);
        TransactionService service = new TransactionService();
        service.spendPoints(user, 50);
        assertEquals(50, user.getBonusPoints()); // Expected balance after spending points
    }

    // Test case to check if an exception is thrown when spending more points than available
    @Test
    void testSpendPointsFail() {
        UserAccount user = new UserAccount(1, "Oleksandr", 30);
        TransactionService service = new TransactionService();
        assertThrows(InsufficientPointsException.class, () -> service.spendPoints(user, 50));
    }
}
