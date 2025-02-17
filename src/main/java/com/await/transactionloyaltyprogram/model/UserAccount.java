package com.await.transactionloyaltyprogram.model;

// Represents a user's account in the loyalty program
public class UserAccount {

    private final int id; // Unique identifier for the user
    private final String name; // User's name
    private int bonusPoints; // Points accumulated by the user

    // Constructor to initialize user account details
    public UserAccount(int id, String name, int bonusPoints) {
        this.id = id;
        this.name = name;
        this.bonusPoints = bonusPoints;
    }

    // Getter for user ID
    public int getId() {
        return id;
    }

    // Getter for user name
    public String getName() {
        return name;
    }

    // Getter for checking available bonus points
    public int getBonusPoints() {
        return bonusPoints;
    }

    // Method to add points to the user's account
    public void addPoints(int points) {
        this.bonusPoints += points;
    }

    // Method to deduct points from the user's account
    public void subtractPoints(int points) {
        this.bonusPoints -= points;
    }
}
