package sample.model;

import java.util.ArrayList;

/**
 * This class is to represent players (Dealer, player1, player2)
 */
public class Player {
    private String name;    // Dealer, player1, player2
    private ArrayList<Integer> hand; //  to track which card(value/suit) the player holds
    private int sum;        // sum of cards picked
    private boolean playing;

    public Player(String name, ArrayList<Integer> hand, int sum, boolean playing){
        this.name = name;
        this.hand = hand;
        this.sum = sum;
        this.playing = playing;
    }


    // getter methods
    public String getName(){
        return name;
    }
    public ArrayList<Integer> getHand(){
        return hand;
    }

    public int getSum(){
        return sum;
    }
    public boolean getPlaying(){
        return playing;
    }

    // setter methods
    public void setName(String name){
        this.name = name;
    }
    public void setHand(ArrayList<Integer> hand) {
        this.hand = hand;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setPlaying(boolean playing){
        this.playing = playing;
    }

}
