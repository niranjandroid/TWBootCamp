package com.tw.bc;

public enum Score {
    COOP_SCORE(2), CHEAT_SCORE(3), NEUTRAL_SCORE(0), LOSER_SCORE(-1);

    private int score;

    Score(int score) {
        this.score = score;
    }

    public int getValue() {
        return score;
    }
}
