package sample.model;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.HashMap;

public class Deck {

    // Suit Constants
    public static final String HEARTS = "♥";
    public static final String DIAMONDS = "♦";
    public static final String SPADES = "♠";
    public static final String CLOVERS = "♣";

    // Rank Constants
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

    private static ArrayList<Card> deckOfCards;

    /**
     * Constructor
     * Arrange all cards here
     */
    public Deck(){
        this.deckOfCards = refillDeck();
    }


    public Deck(ArrayList<Card> deckOfCards){
        this.deckOfCards = deckOfCards;
    }

    public static ArrayList<Card> refillDeck(){
        ArrayList<Card> deckOfCards = new ArrayList<>();
//        deckOfCards.add(new Card(HEARTS, ACE));
//        deckOfCards.add(new Card(HEARTS, TWO));
//        deckOfCards.add(new Card(HEARTS, THREE));
//        deckOfCards.add(new Card(HEARTS, FOUR));
//        deckOfCards.add(new Card(HEARTS, FIVE));
//        deckOfCards.add(new Card(HEARTS, SIX));
//        deckOfCards.add(new Card(HEARTS, SEVEN));
//        deckOfCards.add(new Card(HEARTS, EIGHT));
//        deckOfCards.add(new Card(HEARTS, NINE));
//        deckOfCards.add(new Card(HEARTS, TEN));
//        deckOfCards.add(new Card(HEARTS, JACK));
//        deckOfCards.add(new Card(HEARTS, QUEEN));
//        deckOfCards.add(new Card(HEARTS, KING));

        String[] suit = {HEARTS, DIAMONDS, SPADES, CLOVERS};
        int[] rank = {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
//        deckOfCards.add(new Card(suit[0],rank[0]));

        for (int i = 0; i < 4; i++){
         for (int j = 0; j < 13; j++){
            deckOfCards.add(new Card(suit[i], rank[j]));
         }
        }
        Deck.deckOfCards = deckOfCards;
        return deckOfCards;
    }


    public static ArrayList<Card> getDeckOfCards(){
        return deckOfCards;
    }


    public static void setDeckOfCards(ArrayList<Card> deckOfCards){
        Deck.deckOfCards = deckOfCards;
    }


    @Override
    public String toString() {
        return "Deck{" +
                "deckOfCards=" + deckOfCards +
                '}';
    }
}