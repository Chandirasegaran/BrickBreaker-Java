/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

import java.util.Scanner;

/**
 *
 * @author chandirasegaran
 */
public class Ball {

    static int row = 0;
    static int col = 0;
    static int ballLocationRow;
    static int ballLocationCol;
    static char ball = '\u25CF';
    // static char ball='o';
    static String currentDirection = "tr";

    public Ball(int row, int col) {
        this.row = row;
        this.col = col;
        ballLocationRow = row - 2;
        ballLocationCol = col / 2;

    }

    public void setDirection(String dir, int row, int col) {

        if (dir.equals("tr")) {
            currentDirection = "tr";
        } else if (dir.equals("tl")) {
            currentDirection = "tl";
        } else if (dir.equals("up")) {
            currentDirection = "br";
        }

    }

    public void topRight() {
        currentDirection = "tr";
        ballLocationCol++;
        ballLocationRow--;
    }

    public void topLeft() {
        currentDirection = "tl";
        ballLocationCol--;
        ballLocationRow--;
    }

    public void bottomRight() {
        currentDirection = "br";
        ballLocationCol++;
        ballLocationRow++;

    }

    public void bottomLeft() {
        currentDirection = "bl";
        ballLocationCol--;
        ballLocationRow++;

    }

    public void down() {
        currentDirection = "d";
        ballLocationRow++;
    }

    public void up() {
        currentDirection = "u";
        ballLocationRow--;
    }

    public void ballMovement() {

        if (ballLocationRow == row - 2 && ballLocationCol == Slider.sliderLocation) {
            while (true) {

                System.out.println("Choose a direction (tr, tl, up)");
                Scanner input = new Scanner(System.in);
                String direction = input.next();

                if (direction.equals("tr")) {

                    currentDirection = "tr";
                    break;
                } else if (direction.equals("tl")) {

                    currentDirection = "tl";    
                    break;
                } else if (direction.equals("up")) {

                    currentDirection = "u";
                    break;
                } else {
                    
                    System.out.println("Invalid Direction");
                }
            }
        }

        if (Board.boardContent[ballLocationRow][ballLocationCol] == Slider.slide) {
            if (currentDirection.equals("br")) {
                setDirection("tr", ballLocationRow, ballLocationCol);
            } else if (currentDirection.equals("bl")) {
                setDirection("tl", ballLocationRow, ballLocationCol);
            }
        }
        if (currentDirection.equals("tr")) {
            if (ballLocationCol < col - 1 && ballLocationRow > 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                topRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == col - 1 && ballLocationRow > 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                topLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol < col - 1 && ballLocationRow == 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == col - 1 && ballLocationRow == 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            }

        } else if (currentDirection.equals("tl")) {
            if (ballLocationCol > 0 && ballLocationRow > 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                topLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == 0 && ballLocationRow < 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                topRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol > 0 && ballLocationRow == 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == 0 && ballLocationRow == 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            }
        } else if (currentDirection.equals("br")) {
            if (ballLocationCol < col - 1 && ballLocationRow < row - 1) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == col - 1 && ballLocationRow == row - 1) {
                System.out.println("Game Over");
                System.exit(0);
            } else if (ballLocationCol < col - 1 && ballLocationRow == row - 1) {
                System.out.println("Game Over");
                System.exit(0);
            } else if (ballLocationCol == col - 1 && ballLocationRow < row - 1) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            }
        } else if (currentDirection.equals("bl")) {
            if (ballLocationCol > 0 && ballLocationRow < row - 1) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomLeft();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == 0 && ballLocationRow < row - 1) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                bottomRight();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationCol == col - 1 && ballLocationRow == row - 1) {
                System.out.println("Game Over");
                System.exit(0);
            } else if (ballLocationCol > 0 && ballLocationRow == row - 1) {
                System.out.println("Game Over");
                System.exit(0);
            }

        } else if (currentDirection.equals("d")) {
            if (ballLocationRow < row - 1) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                down();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationRow == row - 1) {
                System.out.println("Game Over");
                System.exit(0);
            }
        } else if (currentDirection.equals("u")) {
            if (ballLocationRow > 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                up();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            } else if (ballLocationRow == 0) {
                Board.boardContent[ballLocationRow][ballLocationCol] = ' ';
                down();
                Board.boardContent[ballLocationRow][ballLocationCol] = ball;
            }
        }

    }

}
