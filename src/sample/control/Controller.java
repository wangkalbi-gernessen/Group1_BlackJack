package sample.control;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.model.Card;       ////
import sample.model.Deck;
import sample.model.Player;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;   ///
import java.util.Random;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    private ArrayList<Player> players = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        players.add(0, new Player("Dealer", new ArrayList<Integer>(), 0, true));
        players.add(1, new Player("Player1", new ArrayList<Integer>(), 0, true));
        Deck deck = new Deck();
        System.out.println(deck);
    }
    // Start button -> Create required objects
    public void gameStart(ActionEvent actionEvent) {
        System.out.println("deckOfCards start with " + Deck.getDeckOfCards().size() + " !");
//        players.add(0, new Player("Dealer", new ArrayList<Integer>(), 0, true));
//        players.add(1, new Player("Player1", new ArrayList<Integer>(), 0, true));
//        System.out.println(players);
        for (int i = 0; i < 2; i++){
            System.out.println(players.get(i));
        }
        System.out.println(players.get(0));
        System.out.println("Game Start!");
    }
    // Pick up random card
    public void hitClicked(ActionEvent actionEvent) {
        System.out.println("hit clicked");
        Random rand = new Random();
        int int_random = rand.nextInt(Deck.getDeckOfCards().size());
        System.out.println("Randomly chosen card is " + Deck.getDeckOfCards().get(int_random));
        int value = Deck.getDeckOfCards().get(int_random).getRank();
        ArrayList<Integer> newHand = playingPlayer(players).getHand();
        newHand.add(value);
        playingPlayer(players).setHand(newHand);        // Add picked value to player's hand
        int newSum = playingPlayer(players).getSum();
        for (int i = 0; i < playingPlayer(players).getHand().size(); i++){
            newSum = newSum + playingPlayer(players).getHand().get(i);
        }
        playingPlayer(players).setSum(newSum);                      // Add all the value from hand
        System.out.println(players);
        Deck.getDeckOfCards().remove(int_random);               // remove the element
        Deck.setDeckOfCards(Deck.getDeckOfCards());             // Set deck of cards
        System.out.println(Deck.getDeckOfCards().size());
    }
    public void standClicked(ActionEvent actionEvent) {
        System.out.println("stand clicked");
    }
    public void escClicked(ActionEvent actionEvent) {
        System.out.println("escape clicked");
        System.exit(0);
    }
    public void helpClicked(ActionEvent actionEvent) {
        System.out.println("help clicked");
    }
    // check a player turn
    public static Player playingPlayer(ArrayList<Player> players){
        Player playingPlayer = null;
        for (int i = 0; i < players.size();i++) {
            if (players.get(i).isPlaying() == false) {
                continue;
            } else {
                playingPlayer = new Player(players.get(i).getName(),players.get(i).getHand(),players.get(i).getSum(),players.get(i).isPlaying());
            }
        }
        return playingPlayer;
    }
    /// Display result (Judge -> use judge class to show the result (Win, bust, push)
}