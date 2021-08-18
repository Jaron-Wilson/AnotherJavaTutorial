package org.mlw.games.ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToePanel extends JPanel {

    protected final static Dimension DEFAULT_MINIMUM_SIZE = new Dimension(300,300);
    protected final static Color[] COLORS = {Color.LIGHT_GRAY, Color.RED, Color.BLUE};

    protected int hoverX = -1;
    protected int hoverY = -1;
    protected int currentShape = 1;

    protected TicTacToeBoard board = null;

    public TicTacToePanel(TicTacToeBoard board) {
        this.board = board;
    }

    @Override
    public Dimension getPreferredSize() {
        return DEFAULT_MINIMUM_SIZE;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GRAY);

        //Draw the horizontal lines on the board.
        g.fillRoundRect(10,95,280, 10, 5,5);
        g.fillRoundRect(10,199,280, 10, 5,5);

        //Draw the vertical lines on the board.
        g.fillRoundRect(95,10,10, 280, 5,5);
        g.fillRoundRect(195,10,10, 280, 5,5);

        //Draw all the already played pieces.
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int piece = board.get(x,y);
                if (piece > 0) {
                    drawShape(x, y, g, COLORS[piece], piece);
                }
            }
        }

        //Draw an X or O under the current mouse position.
        if( hoverX >=0 && hoverY >= 0) {
            int piece = board.get(hoverX, hoverY);
            if ( piece == 0 ) {
                drawShape(hoverX, hoverY, g, COLORS[piece], currentShape);
            }
        }
    }

    private void drawShape(int x, int y, Graphics g, Color color, int shape){
        g.setColor(color);

        switch( shape ) {
            case 1: //Draw a O
                g.fillRoundRect((int) (x * 100 + 15), (int) (y * 100 + 15), 70, 70, 70, 70);
                g.setColor(getBackground());
                g.fillRoundRect((int) (x * 100 + 25), (int) (y * 100 + 25), 50, 50, 50, 50);
                break;

            case 2: //Draw an X
                Polygon polygon = new Polygon();
                polygon.addPoint((int) (x * 100 + 11), (int) (y * 100 + 17));
                polygon.addPoint((int) (x * 100 + 17), (int) (y * 100 + 11));
                polygon.addPoint((int) (x * 100 + 85), (int) (y * 100 + 85));
                polygon.addPoint((int) (x * 100 + 82), (int) (y * 100 + 90));
                g.fillPolygon(polygon);

                polygon = new Polygon();
                polygon.addPoint((int) (x * 100 + 85), (int) (y * 100 + 17));
                polygon.addPoint((int) (x * 100 + 82), (int) (y * 100 + 11));
                polygon.addPoint((int) (x * 100 + 11), (int) (y * 100 + 85));
                polygon.addPoint((int) (x * 100 + 17), (int) (y * 100 + 90));
                g.fillPolygon(polygon);

                break;
        }
    }

    public void setHoverLocation(MouseEvent event){
        setHoverLocation(Math.min(event.getX() / 100, board.getWidth()-1), Math.min(event.getY() / 100, board.getHeight()-1));
    }

    protected void setHoverLocation(int x, int y){
        if( hoverX != x || hoverY != y){
            this.hoverX = x;
            this.hoverY = y;
            SwingUtilities.invokeLater( () -> repaint());
        }
    }

    public void setPiece(MouseEvent event){
        setPiece(Math.min(event.getX() / 100, board.getWidth()-1), Math.min(event.getY() / 100, board.getHeight()-1));

    }

    protected void setPiece(int x, int y){
        if( board.get(x,y) == 0) {
            board.set(x, y, currentShape);
            this.currentShape = currentShape == 1 ? 2 : 1;

            SwingUtilities.invokeLater(() -> repaint());
        }
    }
}