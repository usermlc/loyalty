package com.await.transactionloyaltyprogram.exceptions;

// Custom exception to handle cases when a user does not have enough points
public class InsufficientPointsException extends RuntimeException {

    // Constructor that accepts a message describing the error
    public InsufficientPointsException(String message) {
        super(message); // Passes the message to the RuntimeException constructor
    }
}
