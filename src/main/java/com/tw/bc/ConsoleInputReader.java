package com.tw.bc;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {

    @Override
    public TrustChoice readTrustChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return parseChoice(choice);
    }

    private TrustChoice parseChoice(String choice) {
        try {
            return TrustChoice.getTrustChoiceByValue(choice);
        } catch (InvalidChoiceException e) {
            return readTrustChoice();
        }
    }
}
