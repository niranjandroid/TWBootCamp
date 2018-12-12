package com.tw.bc;

public class ConsoleDisplay implements IDisplay {
    @Override
    public void display(Player playerOne, Player playerTwo) {
        System.out.println("Player 1 : " + playerOne.getScore());
        System.out.println("Player 2 : " + playerTwo.getScore());
    }
}
