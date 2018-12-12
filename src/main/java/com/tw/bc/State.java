package com.tw.bc;

public class State {
    public State(TrustChoice playerOneChoice, TrustChoice playerTwoChoice) {
        this.playerOneChoice = playerOneChoice;
        this.playerTwoChoice = playerTwoChoice;
    }

    private TrustChoice playerOneChoice;
    private TrustChoice playerTwoChoice;

    @Override
    public boolean equals(Object state) {
        if(state instanceof State) {
            return this.playerOneChoice == ((State) state).playerOneChoice
                    && this.playerTwoChoice == ((State) state).playerTwoChoice;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return playerOneChoice.hashCode() + playerTwoChoice.hashCode() * 2;
    }
}
