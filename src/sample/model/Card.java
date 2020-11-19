package sample.model;

import java.util.Objects;

/**
 * This is to represent trump cards
 */
public class Card {

    private boolean isBlack;       // black or red
    private String suit;        // represent ♡, ☘,♠︎, ♦︎
    private int rank;          // represent card number
    private boolean inHand;     // if it is picked or not


    // Constructor for card class
    public Card(boolean isBlack, String suit, int rank, boolean inHand){
        this.isBlack = isBlack;
        this.suit = suit;
        this.rank = rank;
        this.inHand = false;
    }

    // getter methods
    public boolean isBlack() {
        return isBlack;
    }
    public String getSuit(){
        return suit;
    }
    public int getRank(){
        return rank;
    }

    public boolean isInHand() {
        return inHand;
    }

    // setter methods
    public void setBlack(boolean black) {
        isBlack = black;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setInHand(boolean inHand) {
        this.inHand = inHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return isBlack == card.isBlack &&
                rank == card.rank &&
                Objects.equals(suit, card.suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "isBlack=" + isBlack +
                ", suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}
