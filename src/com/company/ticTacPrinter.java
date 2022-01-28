package com.company;

public class ticTacPrinter {

    //this class prints the canvas
    static void printTicTacString(String ticTac) {
        System.out.println(ticTac);
    }

    static void printGameCanvas(char[][] array) {
        System.out.print("---------");
        System.out.printf("%n| %c %c %c |", array[0][0], array[0][1], array[0][2] );
        System.out.printf("%n| %c %c %c |", array[1][0], array[1][1], array[1][2] );
        System.out.printf("%n| %c %c %c |", array[2][0], array[2][1], array[2][2] );
        System.out.printf("%n---------%n");
    }

    static void printGameStatus(String status) {
        if (status == "X-wins") {
            System.out.println("X wins");
        } if (status == "O-wins") {
            System.out.println("O wins");
        } if (status == "Draw") {
            System.out.println("Draw");
        }
    }
}
