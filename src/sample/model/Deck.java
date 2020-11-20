package sample.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Deck {

    private Card[] deckOfCards; // track all the deck of cards
    // Pool of card(53 of them) -> Array? in other file? -> if picked it goes to player's deck
    // -> Remaining card should be tracked

    public Deck(){
        HashMap<String,String> hearts = new HashMap<String,String>();
            hearts.put("A", "♥");
            hearts.put("2", "♥");
            hearts.put("3", "♥");
            hearts.put("4", "♥");
            hearts.put("5", "♥");
            hearts.put("6", "♥");
            hearts.put("7", "♥");
            hearts.put("8", "♥");
            hearts.put("9", "♥");
            hearts.put("10", "♥");
            hearts.put("J", "♥");
            hearts.put("Q", "♥");
            hearts.put("K", "♥");

        ArrayList<HashMap> heart = new ArrayList<>();
        for(int i = 0; i < hearts.size(); i++){
            heart.add(heart.get(i));
        }
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
