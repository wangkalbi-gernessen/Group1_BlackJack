package sample.model;

public class Deck {

    // Hashmap -> Key(0-52), Array(Suit, Value)
    // 1. Heart -> 11,2,3,4,5,6,7,8,9,10,10,10,10


    private Card[] deckOfCards; // track all the deck of cards
    // Pool of card(53 of them) -> Array? in other file? -> if picked it goes to player's deck
    // -> Remaining card should be tracked


    // Constructor  -> Initially it has to have 53 cards
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
