package com.await.transactionloyaltyprogram.service;

import com.await.transactionloyaltyprogram.model.UserAccount;
import com.await.transactionloyaltyprogram.exceptions.InsufficientPointsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Service class to handle transactions related to user bonus points
public class TransactionService {

    private static final Logger logger = LogManager.getLogger(TransactionService.class); // Logger instance for tracking transactions

    // Method to add bonus points to the user's account
    public void earnPoints(UserAccount user, int points) {
        user.addPoints(points);
        TransactionHistory.addTransaction("+" + points + " points added for " + user.getName());
        logger.info("{} points added for user {}", points, user.getName());
    }

    // Method to deduct points when a user spends them
    public void spendPoints(UserAccount user, int points) {
        if (user.getBonusPoints() < points) {
            throw new InsufficientPointsException("Not enough bonus points!"); // Throws an exception if points are insufficient
        }
        user.subtractPoints(points);
        TransactionHistory.addTransaction("-" + points + " points spent by " + user.getName());
        logger.info("{} points spent by user {}", points, user.getName());
    }

    // Method to check the user's current bonus points balance
    public int checkBalance(UserAccount user) {
        return user.getBonusPoints();
    }
}
