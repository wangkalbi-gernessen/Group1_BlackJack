package sample.model;

import java.util.ArrayList;

/**
 * This class is to represent players (Dealer, player1, player2)
 */
public class Player {
    private static String name;    // Dealer, player1, player2
    private static ArrayList<Integer> hand;
    private static int sum;        // sum of cards picked
    private static boolean playing;

    public Player(String name, ArrayList<Integer> hand, int sum, boolean playing){
        this.name = name;
        this.hand = hand;
        this.sum = sum;
        this.playing = playing;
    }


    // getter methods
    public static String getName(){
        return name;
    }
    public static ArrayList<Integer> getHand(){
        return hand;
    }

    public static int getSum(){
        return sum;
    }
    public static boolean getPlaying(){
        return playing;
    }

    // setter methods
    public static void setName(String name){
        Player.name = name;
    }
    public static void setHand(ArrayList<Integer> hand) {
        Player.hand = hand;
    }

    public static void setSum(int sum) {
        Player.sum = sum;
    }

    public static void setPlaying(boolean playing){
        Player.playing = playing;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", sum=" + sum +
                ", playing=" + playing +
                '}' + "\n" ;
    }
}
