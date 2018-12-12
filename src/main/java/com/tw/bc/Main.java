package com.tw.bc;

public class Main {

    public static void main(String[] args) {
        InputReader inputReader = new ConsoleInputReader();
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(new Player(inputReader),
                new Player(inputReader), new ConsoleDisplay());
        evolutionOfTrust.start();
    }
}
