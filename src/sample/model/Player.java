package sample.model;

/**
 * This class is to represent players (Dealer, player1, player2)
 */
public class Player {
    private String name;    // Dealer, player1, player2
    private Card[] hand;   //  to track which card(value/suit) the player holds
    private int sum;        // sum of cards picked

    public Player(String name, Card[] hand, int sum){
        this.name = name;
        this.hand = hand;
        this.sum = sum;
    }


    // getter methods
    public String getName(){
        return name;
    }
    public Card[] getHand(){
        return hand;
    }

    public int getSum(){
        return sum;
    }

    // setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}
