package com.tw.bc;

public class ScoreManager {

    public void updateScores(Player playerOne, TrustChoice playerOneChoice,
                             Player playerTwo, TrustChoice playerTwoChoice) {

        State state = new State(playerOneChoice, playerTwoChoice);
        IUpdateScore scoreUpdater = new RuleEngine().getScoreUpdater(state);
        scoreUpdater.updateScores(playerOne, playerTwo);
    }
}
