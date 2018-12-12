package com.tw.bc;

public class Player {
    private int score;

    public int getScore() {
        return score;
    }

    public void addScore(Score score) {
        this.score += score.getValue();
    }

    public TrustChoice play(InputReader inputReader) {
        return inputReader.readTrustChoice();
    }
}
