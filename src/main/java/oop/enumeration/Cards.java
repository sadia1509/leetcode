package oop.enumeration;

public enum Cards {
    HEARTS("Hearts", "Red"),
    DIAMONDS("Diamonds", "Red"),
    CLUBS("Clubs", "Black"),
    SPADES("Spades", "Black");

    private final String displayName;
    private final String color;

    // Constructor for the enum constants
    Cards(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }

    // Getter methods
    public String getDisplayName() {
        return displayName;
    }

    public String getColor() {
        return color;
    }
}

