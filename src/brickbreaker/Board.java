/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author chandirasegaran
 */
public class Board{

    static char[][] boardContent;
    static int row = 0;
    static int col = 0;

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        boardContent = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boardContent[i][j] = ' ';

            }
        }

    }

    public void printBoard() {
        // Clear the Screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < col+2; i++) {
            System.out.print('\u2581');
        }
        System.out.println();
        for (int i = 0; i < row; i++) {
            System.out.print('\u258f');
            for (int j = 0; j < col; j++) {
                System.out.print(boardContent[i][j]);
            }
            System.out.println('\u2595');
        }
        for (int i = 0; i < col+2; i++) {
            System.out.print('\u2594');
        }
    }

}
