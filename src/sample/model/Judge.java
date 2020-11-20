package sample.model;



/**
 * This is to judge the end of game: WIN/BUST/PUSH
 */
public class Judge extends Player {
    public boolean onPlay;

    public Judge(String name, Card[] deck, int sum, boolean onPlay){
        super(name, deck, sum);
        this.onPlay = true;
    }


    // Ger result method Here (depends on the sum of the deck)
        // - One bust: One player sum <= 21 & the other sum > 21
        // - both not bust: one player sum <=21 & the other sum <= 21 -> Which ever closer to 21, wins
        // - both bust (PUSH: one player sum > 21 & the other sum > 21 & one player sum <= 21 & the other sum <= 21
        // when sum == 21 -> BlackJack
        // // When onPlay is false (-> Play again)

}

