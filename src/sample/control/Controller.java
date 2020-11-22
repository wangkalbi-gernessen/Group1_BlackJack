package sample.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.model.Card;       ////
import sample.model.Deck;
import sample.model.Player;
import sample.view.HelpWindow;

import java.net.URL;
import java.util.ArrayList;   ///
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    ///////////////////////////////////////////////////
    // Card Widths for displaying hands
    private static final Integer CARD_WIDTH_TOP = 70;       // The most top card has full width
    private static final Integer CARD_WIDTH_UNDER = 25;     // The other cards have narrow width
    ///////////////////////////////////////////////////
    @FXML
    public Button btnStart;
    @FXML
    public ImageView imgViewDealer;
    @FXML
    public HBox hBoxDealer;

    private ArrayList<Player> players = new ArrayList<>();
    private int cntClick = 0;   // for testing: count up when "Start" is clicked

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
        for (int i = 0; i < 2; i++) {
            System.out.println(players.get(i));
        }
        System.out.println(players.get(0));
        System.out.println("Game Start!");

        // Hide Start Button after game starting
        btnStart.setVisible(false);

        // testing: display hands
        displayHands();
    }

    /**
     * Display hands with test data
     * Rank should be static final valuables in Deck or Card class to use card numbers as they abbreviations (e.g. A, 2, J, Q, K)
     */
    private void displayHands() {
        imgViewDealer.setVisible(false);
        switch (cntClick) {
            case 0:
                updateHands(Deck.HEARTS, "5");
                cntClick++;
                break;
            case 1:
                updateHands(Deck.SPADES, "10");
                cntClick++;
                break;
            case 2:
                updateHands(Deck.DIAMONDS, "J");
                cntClick++;
                break;
            case 3:
                updateHands(Deck.CLOVERS, "A");
                cntClick++;
                break;
            default:
                break;
        }

        hBoxDealer.setVisible(true);
        // Keep Start button visible for testing
        btnStart.setVisible(true);
    }

    /**
     * Add a new card and display
     *
     * @param suit suit of new card
     * @param rank rank of new card
     */
    private void updateHands(String suit, String rank) {
        List<Node> cards = hBoxDealer.getChildren();
        if (cards.size() == 0) {
            // No cards: add with full width
            Label card = generateCard(suit, rank, CARD_WIDTH_TOP);
            hBoxDealer.getChildren().add(card);
        } else {
            // Multiple cards: set the current last card to narrow width and add a new card
            Label lastCard = (Label) cards.get(cards.size() - 1);
            lastCard.setPrefSize(CARD_WIDTH_UNDER, hBoxDealer.getHeight());
            Label card = generateCard(suit, rank, CARD_WIDTH_TOP);
            hBoxDealer.getChildren().add(card);
        }
        hBoxDealer.setAlignment(Pos.CENTER);
    }

    /**
     * Generate Label of a new card
     * @param suit
     * @param rank
     * @param width
     * @return
     */
    private Label generateCard(String suit, String rank, double width) {
        Label card = new Label();
        card.setText(suit + "\n" + rank);
        card.setAlignment(Pos.TOP_LEFT);
        card.setFont(new Font("Arial", 15));
        card.setPrefSize(width, hBoxDealer.getHeight());
        card.setStyle("-fx-border-color:gray; -fx-background-color: white;");
        Color fontColor = (suit.equals(Deck.HEARTS) || suit.equals(Deck.DIAMONDS)) ? Color.RED : Color.BLACK;
        card.setTextFill(fontColor);
        card.setPadding(new Insets(0, 0, 0, 3));
        return card;
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
        for (int i = 0; i < playingPlayer(players).getHand().size(); i++) {
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
        HelpWindow.displayHelp(actionEvent, getClass());
    }

    // check a player turn
    public static Player playingPlayer(ArrayList<Player> players) {
        Player playingPlayer = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).isPlaying() == false) {
                continue;
            } else {
                playingPlayer = new Player(players.get(i).getName(), players.get(i).getHand(), players.get(i).getSum(), players.get(i).isPlaying());
            }
        }
        return playingPlayer;
    }
    /// Display result (Judge -> use judge class to show the result (Win, bust, push)
}