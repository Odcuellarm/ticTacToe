package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ticTacGame {

    //store the current status of the game
    //check inputs for movements are correct
    //update game status
    private char[][] ticTac;
    private int length;
    private String gameStatus;
    Scanner scanner = new Scanner(System.in);
    //String[] playerOne; // [typeOfPlayer, mark]
    //String[] playerTwo; // [typeOfPlayer, mark]


    //public void setPlayers(String typePlayer1, String typePlayer2) {
    //
    //     this.playerOne = {typePlayer1, "X"};
    //     this.playerTwo = {typePlayer2, "O"};
    //
    //}


    public ticTacGame() {
        this.ticTac = new char[][]{{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        this.length = this.ticTac.length;
        this.gameStatus = "Game not finished";
    }

    public void playerOneMoves() {
        String coordinates;

        do{
            System.out.print("Enter the coordinates: ");
            coordinates = scanner.nextLine();
        } while (!validateCoordinates(coordinates));
        updateCanvas(coordinates, "playerOne");
    }

    public void playerTwoMoves() {
        int x;
        int y;
        String coordinates;
        Random random = new Random();

        System.out.println("Making move level \"easy\"");
        do {
            //generate random coordinates
            x = random.nextInt(this.length) + 1;
            y = random.nextInt(this.length) + 1;
        } while (!availableCell(x, y));
        coordinates = x + " " + y;
        updateCanvas(coordinates, "playerTwo");
    }

    public void updateCanvas(String xy, String player) {
        int x;
        int y;
        char currentChar = ' ';

        x = Integer.parseInt(xy.substring(0, 1));
        y = Integer.parseInt(xy.substring(2));

        switch (player) {
            case("playerOne"):
                currentChar = 'X';
                break;
            case("playerTwo"):
                currentChar = 'O';
                break;
        }
        this.ticTac[x -1][y - 1] = currentChar;
    }

    public boolean validateCoordinates(String xy) {

        int x, y;

        try {
            x = Integer.parseInt(xy.substring(0, 1));
            y = Integer.parseInt(xy.substring(2));
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (x > 3 || y > 3 || x == 0 || y == 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (!availableCell(x, y)) {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    public boolean availableCell(int x, int y) {

        if (this.ticTac[x - 1][y -1] != ' ') {
            return false;
        }
        return true;
    }

    public void updateGameStatus() {

        int[] oCombinations = new int[]{0, 0, 0, 0}; // [row, col, diagonalLR, diagonalRL]
        int[] xCombinations = new int[]{0, 0, 0, 0};

        for(int i = 0; i < this.length; i++) {
            xCombinations[0] = 0;
            xCombinations[1] = 0;
            oCombinations[0] = 0;
            oCombinations[1] = 0;

            for(int j = 0; j < this.ticTac.length; j++) {
                //Checks Horizontally (rows)
                if (this.ticTac[j][i] == 'X') {
                    xCombinations[0] += 1;
                }
                if (this.ticTac[j][i] == 'O') {
                    oCombinations[0] += 1;
                }
                //Checks vertically (columns)
                if (this.ticTac[i][j] == 'X') {
                    xCombinations[1] += 1;
                }
                if (this.ticTac[i][j] == 'O') {
                    oCombinations[1] += 1;
                }
            }
            if (xCombinations[0] == 3 || xCombinations[1] == 3 || oCombinations[0] == 3 || oCombinations[1] == 3) {
                break;
            }
            //checks Diagonal from left to right
            if (this.ticTac[i][i] == 'X') {
                xCombinations[2] += 1;
            }
            if (this.ticTac[i][i] == 'O') {
                oCombinations[2] += 1;
            }
            //checks Diagonal from right to left
            if (this.ticTac[i][this.length -1 -i] == 'X') {
                xCombinations[3] += 1;
            }
            if (this.ticTac[i][this.length -1 -i] == 'O') {
                oCombinations[3] += 1;
            }

        }
        for (int count : xCombinations) {
            if (count == this.length) {
                this.gameStatus = "X-wins";
            } else if (getTicTacString().length() == 9) {
                this.gameStatus = "Draw";
            }
        }
        for(int count : oCombinations) {
            if (count == this.length) {
                this.gameStatus = "O-wins";
            } else if (getTicTacString().length() == 9) {
                this.gameStatus = "Draw";
            }
        }
    }

    ////////////  GETTERS  //////////////////////////////////////////

    public String getTicTacString(){
        //returns a string containing the Xs and Os in the canvas
        String ticTacString;
        StringBuilder stringBuilder = new StringBuilder();
        for(int row = 0; row < length; row++) {
            for(int elem = 0; elem < length; elem++) {
                stringBuilder.append(this.ticTac[row][elem]);
            }
        }
        ticTacString = stringBuilder.toString().replace(" ", "");
        return  ticTacString;
    }

    public char[][] getTicTac() {
        return this.ticTac;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }

}
