package sample.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    private static String HEARTS = "♥";
    private static String SPADES = "♠";
    private static String CLOVERS = "♣";
    private static String DIAMONDS = "♦";
    private static int ACE = 11;
    private static int TWO = 2;
    private static int THREE = 3;
    private static int FOUR = 4;
    private static int FIVE = 5;
    private static int SIX = 6;
    private static int SEVEN = 7;
    private static int EIGHT = 8;
    private static int NINE = 9;
    private static int TEN = 10;
    private static int JACK = 10;
    private static int QUEEN = 10;
    private static int KING = 10;

    // Hashmap -> Key(0-52), Array(Suit, Value)
    // 1. Heart -> 11,2,3,4,5,6,7,8,9,10,10,10,10
    private Card[] deckOfCards; // track all the deck of cards
    // Pool of card(53 of them) -> Array? in other file? -> if picked it goes to player's deck
    // -> Remaining card should be tracked

    /**
     * Constructor
     * Arrange all cards here
     */
    public Deck(){
        ArrayList<Card> trumps = new ArrayList<Card>();
        trumps.add(new Card(HEARTS, ACE));
        trumps.add(new Card(HEARTS, TWO));
        trumps.add(new Card(HEARTS, THREE));
        trumps.add(new Card(HEARTS, FOUR));
        trumps.add(new Card(HEARTS, FIVE));
        trumps.add(new Card(HEARTS, SIX));
        trumps.add(new Card(HEARTS, SEVEN));
        trumps.add(new Card(HEARTS, EIGHT));
        trumps.add(new Card(HEARTS, NINE));
        trumps.add(new Card(HEARTS, TEN));
        trumps.add(new Card(HEARTS, JACK));
        trumps.add(new Card(HEARTS, QUEEN));
        trumps.add(new Card(HEARTS, KING));
    }

//     Constructor  -> Initially it has to have 53 cards
    public Deck(Card[] deckOfCards){
        this.deckOfCards = deckOfCards;
    }

    // getter
    public Card[] getDeckOfCards() {
        return deckOfCards;
    }

    // setter
    public void setDeckOfCards(Card[] deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}