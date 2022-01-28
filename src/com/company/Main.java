package com.company;

public class Main {

    public static void main(String[] args) {

        ticTacGame ticTac = new ticTacGame();
        ticTacPrinter.printGameCanvas(ticTac.getTicTac());

        do {
            //player one moves --> check valid move
            ticTac.playerOneMoves();
            ticTacPrinter.printGameCanvas(ticTac.getTicTac());
            ticTac.updateGameStatus(); //problem here
            ticTacPrinter.printGameStatus(ticTac.getGameStatus()); //problem here

            if (ticTac.getGameStatus() == "Game not finished") {
                //ai moves
                ticTac.playerTwoMoves();
                ticTacPrinter.printGameCanvas(ticTac.getTicTac());
                ticTac.updateGameStatus();
                ticTacPrinter.printGameStatus(ticTac.getGameStatus());
            }

        } while (ticTac.getGameStatus() == "Game not finished");

    }
}
