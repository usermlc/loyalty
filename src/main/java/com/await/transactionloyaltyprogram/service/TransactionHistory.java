package com.await.transactionloyaltyprogram.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

// Utility class to manage transaction history in the loyalty program
public class TransactionHistory {

    private static final Logger logger = LogManager.getLogger(TransactionHistory.class); // Logger instance for logging
    private static final List<String> transactionRecords = new ArrayList<>(); // List to store transaction records

    // Private constructor to prevent instantiation of this utility class
    private TransactionHistory() {
        // Prevents the creation of instances
    }

    // Adds a transaction record to the history
    public static void addTransaction(String transactionRecord) {
        transactionRecords.add(transactionRecord);
    }

    // Logs and prints the transaction history
    public static void printHistory() {
        logger.info("\nTransaction history:");
        transactionRecords.forEach(logger::info); // Logs each transaction in the history
    }
}
