package com.tw.bc;

public enum TrustChoice {
    CHEAT("-"), COOPERATE("+");

    private String choice;

    TrustChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return choice;
    }

    public static TrustChoice getTrustChoiceByValue(String choice) throws InvalidChoiceException {
        for(TrustChoice trustChoice : TrustChoice.values()) {
            if(trustChoice.toString().equals(choice)) {
                return trustChoice;
            }
        }
        throw new InvalidChoiceException("Invalid input for choice");
    }
}
