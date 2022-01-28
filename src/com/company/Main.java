package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ticTacGame ticTac = new ticTacGame();
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Input command: ");
        //do{
        //  String input = scanner.nextLine();
        //
        // } while();

        ticTacPrinter.printGameCanvas(ticTac.getTicTac());

        //start easy user
        //ticTac.initPlayers(

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
