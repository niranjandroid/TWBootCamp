package com.tw.bc;

public class Player {
    private int score;
    private InputReader inputReader;
    public Player(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public int getScore() {
        return score;
    }

    public void addScore(Score score) {
        this.score += score.getValue();
    }

    public TrustChoice play() {
        return inputReader.readTrustChoice();
    }
}
