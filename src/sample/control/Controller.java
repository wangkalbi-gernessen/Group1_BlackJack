package sample.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.model.Card;
import sample.model.Deck;
import sample.model.Player;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Button id property
    @FXML
    public Button btn2;


    // Start game
    // Initialization HERE, take user input as an argument!!
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //1.  Initializing instance variables(properties) //
        // Depends on user select (Single player or 2 players)
        // if single -> Create a player
        // if 2 players -> create two players
        Player dealer = new Player("Dealer", new ArrayList<Integer>(), 0, false);
        Player player1 = new Player("Player1", new ArrayList<Integer>(), 0, true);
        Player player2 = new Player("Player2", new ArrayList<Integer>(),0, false);
//        Deck deck = new deck();

        // button from grid
        // Judge
        //2. Display player name on Label
        // changeLabel()    ; to track turn
    }

    // Each Button action event HERE//

    //btn2)----------HIT CARD-------------------------------------------
    public int HitClicked(ActionEvent actionEvent) {
        int valueHit = HitCard(0);
        // Add the card to Player's hand
        // Decrease from Deck
        // Pick a random card from Deck
        return valueHit;
    }

    // take deck size (pass HashMap Deck as argument
    public int deckSize(){
        // return decksize;
        return 0;
    }

    // Return a random card from Deck, return its value
    public int HitCard(int deckSize){
        // if
        deckSize = 13;    // Number of Deck elements
        Card card = new Card("HEART",13,false);
        Random rand = new Random();
        int int_random = rand.nextInt(deckSize);
        // return hashmap name.get(int_random);    //take out value with pair of the int_random(key)
        // set new Deck after removing the element Here
        // change turn
        return 0;
    }

    // Add picked card to Hand of player
    public ArrayList<Integer> addCard(Player player, ArrayList<Integer> hand, int hitValue){
        ArrayList<Integer> newHand = player.getHand();
        newHand.add(hitValue);
        player.setHand(newHand);
        return hand;
    }

    // Calculate & Display sum     -------> just return total sum
    public int displaySum(Player player){
        int handSum = 0;
        int element = player.getHand().size();
        for (int i = 0; i < element; i++){
            handSum = handSum + player.getHand().get(i);
        }
        return handSum;
    }



    //-------------------------------------------------------//

    // --------STAND------- not draw, skip player///






    // 3. Take Turns (method: ChangeLabel) -> single player = dealer and a player
    public void ChangeTurn(Player player){
        player.setPlaying(false);
    }





    /// Display result (Judge -> use judge class to show the result (Win, bust, push)





    // Display game rule(Associate to HELP button)




    // a method to quit









}
