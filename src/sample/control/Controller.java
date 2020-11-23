package sample.control;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
// <<<<<<< kazu_confirmation_dialog
import sample.model.Card;       ////
// =======
// import sample.model.Card;
// >>>>>>> main
import sample.model.Deck;
import sample.model.Player;
import sample.view.HelpWindow;

import java.net.URL;
// <<<<<<< kazu_confirmation_dialog
import java.util.ArrayList;   ///
import java.util.Optional;
// =======
// import java.util.ArrayList;
// >>>>>>> main
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    public Button btnStart;
    @FXML
    public Button btnStand1;
    @FXML
    public Button btnStand2;
    @FXML
    public Button btnHit1;
    @FXML
    public Button btnHit2;
    @FXML
    public Button btnHelp;
    @FXML
    public Button btnEsc;
    // by Kazunobu
    @FXML
    public Label labelSum1;
    @FXML
    public Label labelSum2;
    @FXML
    public Label labelSumDealer;

    private Deck deck;
    private ArrayList<Player> players = new ArrayList<>();
    private boolean isGameRunning;
    private Player turn;
    private int playerInt;
    private Player player;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Deck deck = new Deck();
        players.add(0, new Player("Player1", new ArrayList<Integer>(), 0, true));
        players.add(1, new Player("Player2", new ArrayList<Integer>(),0, false));
        players.add(2, new Player("Dealer", new ArrayList<Integer>(), 0, false));
    }


    public void gameStart(ActionEvent actionEvent) {
        System.out.println("deckOfCards start with " + Deck.getDeckOfCards().size() + " !");
        for (int i = 0; i < 3; i++){
            System.out.println(players.get(i));
        }
        System.out.println("Game Start!");
        isGameRunning = true;
        // Hide Start Button after game starting
        btnStart.setVisible(false);
        playerInt = 0;
        enableDisableButton(getTurn(playerInt));
    }

    public Player getTurn(int playerInt){
        return players.get(playerInt);
    }

    public void enableDisableButton(Player player){
        if(player == players.get(0)){
            btnHit1.setDisable(false);
            btnStand1.setDisable(false);
            btnHit2.setDisable(true);
            btnStand2.setDisable(true);
        }
        else if (player == players.get(1)){
            btnHit2.setDisable(false);
            btnStand2.setDisable(false);
            btnHit1.setDisable(true);
            btnStand1.setDisable(true);
        } else {
            btnHit1.setDisable(true);
            btnStand1.setDisable(true);
            btnHit2.setDisable(true);
            btnStand2.setDisable(true);
            //------------- Dealer method HERE----------------------
            int value = pickCard(player, deck);
            player.setHand(addToHand(player,value));
            player.setSum(totalSum(player));
            System.out.println(players.get(2));
            playerInt = 0;
            enableDisableButton(players.get(playerInt));
            //------------------------------------------------------
        }
    }

    public int pickCard(Player player, Deck deck){
        Random rand = new Random();
        int int_random = rand.nextInt(Deck.getDeckOfCards().size());
        System.out.println("Randomly chosen card for " + player.getName() + " is" + Deck.getDeckOfCards().get(int_random));
        int value = Deck.getDeckOfCards().get(int_random).getRank();
        Deck.getDeckOfCards().remove(int_random);
        Deck.setDeckOfCards(Deck.getDeckOfCards());
        return value;
    }

    public ArrayList<Integer> addToHand(Player player, int value){
        ArrayList<Integer> newHand = player.getHand();
        newHand.add(value);
        return newHand;
    }

    public int totalSum(Player player){
        int newSum = 0;
        for (int i = 0; i < player.getHand().size();i++){
            newSum = newSum + player.getHand().get(i);
        }
        // by Kazunobu
        displayPlayerSum(player, newSum);
        return newSum;
    }

    // by Kazunobu
    public void displayPlayerSum(Player player, int sum){
        if(player.getName().equals("Player1")){
            labelSum1.setText("Player1 sum:" + sum);
        }else if(player.getName().equals("Player2")){
            labelSum2.setText("Player2 sum:" + sum);
        }else{
            labelSumDealer.setText("Dealer sum:" + sum);
        }
    }

    public void hitClicked(ActionEvent actionEvent) {
        player = getTurn(playerInt);
        player.setHand(addToHand(player, pickCard(player, deck)));
        player.setSum(totalSum(player));
        System.out.println(player);

        Button hitClicked = (Button) actionEvent.getSource();
        String hitButtonId = hitClicked.getId();
        if (hitButtonId.equals("btnHit1")){
            playerInt++;
        } else if (hitButtonId.equals("btnHit2")){
            playerInt++;
        }
        enableDisableButton(getTurn(playerInt));
    }

    public void standClicked(ActionEvent actionEvent) {
        Button hitClicked = (Button) actionEvent.getSource();
        String hitButtonId = hitClicked.getId();
        if(hitButtonId.equals("btnStand1")){
            playerInt++;
            System.out.println("btnStand1 clicked");
        } else if(hitButtonId.equals("btnStand2")){
            playerInt = 0;
            System.out.println("btnStand2 clicked");
        }
        enableDisableButton(getTurn(playerInt));
    }


    public void escClicked(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Do you quit this game?");
        ButtonType continueBtn = new ButtonType("Continue", ButtonBar.ButtonData.OK_DONE);
        ButtonType quitBtn = new ButtonType("Quit", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(continueBtn,quitBtn);
        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == quitBtn){
            System.exit(0);
        }
    }


    public void helpClicked(ActionEvent actionEvent) {
        System.out.println("help clicked");
        HelpWindow.displayHelp(actionEvent, getClass());
    }

    /// Display result (Judge -> use judge class to show the result (Win, bust, push)

}