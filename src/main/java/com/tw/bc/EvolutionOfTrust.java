package com.tw.bc;

public class EvolutionOfTrust {

    private Player playerOne;
    private Player playerTwo;
    private IDisplay display;
    public static final int NO_OF_ROUNDS = 5;

    public EvolutionOfTrust(Player playerOne, Player playerTwo, IDisplay display) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.display = display;
    }

    public void start() {
        ScoreManager scoreManager = new ScoreManager();
        for(int i = 0; i < NO_OF_ROUNDS; i++) {
            display.display(playerOne, playerTwo);
            TrustChoice playerOneChoice = playerOne.play();
            TrustChoice playerTwoChoice = playerTwo.play();
            scoreManager.updateScores(playerOne, playerOneChoice, playerTwo, playerTwoChoice);
        }
        display.display(playerOne, playerTwo);
    }
}
