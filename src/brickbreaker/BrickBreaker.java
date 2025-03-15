/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package brickbreaker;

import java.util.Scanner;

/**
 *
 * @author chandirasegaran
 */
public class BrickBreaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row=16;
        int col=19;

        Slider sliderBoard = new Slider(row, col);
        sliderBoard.boardObj.printBoard();
        Ball ballob = new Ball(row, col);
        System.out.println("");
        while (true) {
            char move = input.next().charAt(0);
            if (move == 'l') {
                sliderBoard.moveLeft();
                sliderBoard.boardObj.printBoard();
                System.out.println("");

            } else if (move == 'r') {
                sliderBoard.moveRight();
                sliderBoard.boardObj.printBoard();
                System.out.println("");

            } else if (move == 'q') {
                System.out.println("Bye Bye!");
                System.exit(0);
            }

            else {
                sliderBoard.boardObj.printBoard();
                System.out.println("");

            }
  
            ballob.ballMovement();
            sliderBoard.boardObj.printBoard();

        }

    }

}
