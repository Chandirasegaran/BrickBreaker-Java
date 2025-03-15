/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package brickbreaker;

/**
 *
 * @author chandirasegaran
 */
public class Slider {

    static char slide = '\u2594';
    static int sliderLocation;
    static int row = 0;
    static int col = 0;
    static Board boardObj;
    static Ball ballObj;
    public Slider(int row, int col) {
        boardObj = new Board(row, col);
        boardObj.boardContent[row-1][col/2]=slide;
        boardObj.boardContent[row-2][col/2]=ballObj.ball;
        sliderLocation=col/2;
        this.row = row;
        this.col = col;
    }

    public void moveLeft() {
        if (sliderLocation > 0) {
            boardObj.boardContent[row-1][sliderLocation]=' ';
            sliderLocation--;
            boardObj.boardContent[row-1][sliderLocation]=slide;
            
        }
    }

    public void moveRight() {
        if (sliderLocation < col - 1) {
            boardObj.boardContent[row-1][sliderLocation]=' ';
            sliderLocation++;
            boardObj.boardContent[row-1][sliderLocation]=slide;
        }
    }



}
