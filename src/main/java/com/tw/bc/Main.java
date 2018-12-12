package com.tw.bc;

public class Main {

    public static void main(String[] args) {
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(new Player(),
                new Player(), new ConsoleDisplay());
        evolutionOfTrust.start(new ConsoleInputReader(), new ConsoleInputReader());
    }
}
