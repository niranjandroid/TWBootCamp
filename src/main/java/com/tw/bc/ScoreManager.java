package com.tw.bc;

public class ScoreManager {

    public void updateScores(Player playerOne, TrustChoice playerOneChoice,
                             Player playerTwo, TrustChoice playerTwoChoice) {

        State state = new State(playerOneChoice, playerTwoChoice);
        Score[] scores = new RuleEngine().getScoreUpdater(state);
        playerOne.addScore(scores[0]);
        playerTwo.addScore(scores[1]);
    }
}
