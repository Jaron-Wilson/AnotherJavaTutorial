package org.mlw.games.ttt;

/**
 * Holds the state of the game, the model.
 */
public class TicTacToeBoard {

    //The board is initialized with all zeros. A Zero signifies an empty spot on the 3x3 board.
    private final int board[][];

    public TicTacToeBoard(int width, int height){
        board = new int[width][height];
    }

    /**
     * Rests the board back to all zeros.
     */
    public void reset(){
        for (int x = 0, w = getWidth(); x < w; x++) {
            for (int y = 0, h = getHeight(); y < h; y++) {
                board[x][y] = 0;
            }
        }
    }

    public int get(int x, int y){
        return board[x][y];
    }

    public void set(int x, int y, int piece){
        board[x][y] = piece;
    }

    public int getWidth(){ return board.length;}
    public int getHeight(){ return board[0].length;}
}