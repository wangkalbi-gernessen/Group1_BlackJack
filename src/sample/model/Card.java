package sample.model;

import java.util.Objects;

/**
 * This is to represent trump cards
 */
public class Card {

    private String suit;        // represent ♡, ☘,♠︎, ♦︎　
    private int rank;           // represent card number


    // Constructor for card class
    public Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    // getter methods
    public String getSuit(){
        return suit;
    }
    public int getRank(){
        return rank;
    }

    // setter methods
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}' + "\n";
    }
}
