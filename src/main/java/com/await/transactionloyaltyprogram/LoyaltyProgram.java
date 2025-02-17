package com.await.transactionloyaltyprogram;

import com.await.transactionloyaltyprogram.model.UserAccount;
import com.await.transactionloyaltyprogram.service.TransactionService;
import com.await.transactionloyaltyprogram.service.TransactionHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Main class for running the loyalty program
public class LoyaltyProgram {

    private static final Logger logger = LogManager.getLogger(LoyaltyProgram.class); // Logger for tracking program activity

    public static void main(String[] args) {
        // Creating a user account with initial bonus points
        UserAccount user = new UserAccount(1, "Oleksandr", 100);
        TransactionService service = new TransactionService(); // Service for handling transactions

        // Adding and spending points
        service.earnPoints(user, 50); // User earns 50 points
        service.spendPoints(user, 80); // User spends 80 points

        // Attempting to spend more points than available to trigger an exception
        try {
            service.spendPoints(user, 100);
        } catch (Exception e) {
            logger.error("Error: Not enough bonus points. User balance: {} points", service.checkBalance(user), e);
        }

        // Logging final balance and printing transaction history
        logger.info("Balance: {} points", service.checkBalance(user));
        TransactionHistory.printHistory();
    }
}
