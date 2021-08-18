package org.mlw.games.ttt;

import javax.swing.*;
import java.awt.event.*;

/** This class assembles the game into a JFrame, registers listeners and displays.
 *
 * @author Matthew L. Wilson
 */
public class Launcher {
    public static void main(String[] args){
        //Create the model for the game.
        TicTacToeBoard board = new TicTacToeBoard(3,3);

        //Create the panel that displays the tic tac toe board.
        TicTacToePanel panel = new TicTacToePanelDynamic(board);

        //Create a frame to hold the game.
        JFrame frame = new JFrame();

        //Add our custom panel that renders the game.
        frame.add(panel);

        //Close the program when the user clicks the x.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Show and pack the frame.
        frame.setVisible(true);
        frame.pack();

        //Register a listener so an X or O can be rendered as the mouse moves.
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                panel.setHoverLocation(e);
            }
        });

        //Register a listener to capture when a piece is to be played.
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                panel.setPiece(e);
                whoWon(board);
            }
        });

        //Register a listener that resets the board when a key is pressed.
        frame.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if( e.getKeyChar() == 'n'){
                    board.reset();
                    SwingUtilities.invokeLater( () -> panel.repaint());
                }
            }
        });
    }

    public static void whoWon(TicTacToeBoard board){
        System.out.println("Who won? ");
        for (int x = 0, w = board.getWidth(); x < w; x++) {
            for (int y = 0, h = board.getHeight(); y < h; y++) {
                System.out.print(board.get(y,x));
            }
            System.out.println();
        }

        if( board.get(0,0) == 1 && board.get(1,0)==1 && board.get(2,0) == 1){
            System.out.println("O Won!");
        }
        if( board.get(0,0) == 2 && board.get(1,0)==2 && board.get(2,0) == 2){
            System.out.println("X Won!");
        }
        if( board.get(0,1) == 0 && board.get(1,1)==1 && board.get(2,1) == 0){
            System.out.println("6 Won!");
        }

    }
}
