package org.mlw.games.ttt;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;

public class TicTacToePanelDynamic extends TicTacToePanel {

    private boolean initialized = false;

    protected int cellHeight = 100;
    protected int cellWidth = 100;

    public TicTacToePanelDynamic(TicTacToeBoard board) {
        super(board);
        this.addComponentListener(componentAdapter);
    }

    @Override
    public void paint(Graphics g) {

        if( !initialized ){
            initialized = true;
            componentAdapter.componentResized(null);
        }

        g.setColor(getBackground());
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(Color.GRAY);

        int width = getWidth();
        int height = getHeight();

        for (int i=1, h = board.getHeight(); i<h; i++){
            g.fillRoundRect(10,cellHeight * i -5,width - 20, 10, 5,5);
        }

        for (int i=1, w = board.getWidth(); i<w; i++){
            g.fillRoundRect(cellWidth * i - 5,10,10, height - 20, 5,5);
        }

        //Draw all the already played pieces.
        for (int x = 0, w = board.getWidth(); x < w; x++) {
            for (int y = 0, h = board.getHeight(); y < h; y++) {
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
                g.fillRoundRect((int) (x * cellWidth + 15), (int) (y * cellHeight + 15), cellWidth-30, cellHeight-30, cellWidth, cellHeight);
                g.setColor(getBackground());
                g.fillRoundRect((int) (x * cellWidth + 25), (int) (y * cellHeight + 25), cellWidth-50, cellHeight-50, cellWidth-20, cellHeight-20);
                break;

            case 2: //Draw an X
                Polygon polygon = new Polygon();
                polygon.addPoint((int) (x * cellWidth + 11), (int) (y * cellHeight + 17));
                polygon.addPoint((int) (x * cellWidth + 17), (int) (y * cellHeight + 11));
                polygon.addPoint((int) (x * cellWidth + (cellWidth-15)), (int) (y * cellHeight + (cellHeight-15)));
                polygon.addPoint((int) (x * cellWidth + (cellWidth-15)), (int) (y * cellHeight + (cellHeight-10)));
                g.fillPolygon(polygon);

                polygon = new Polygon();
                polygon.addPoint((int) ((x+1) * cellWidth - 15), (int) (y * cellHeight + 18));
                polygon.addPoint((int) ((x+1) * cellWidth - 18), (int) (y * cellHeight + 11));
                polygon.addPoint((int) (x * cellWidth + 11), (int) ((y+1) * cellHeight - 15));
                polygon.addPoint((int) (x * cellWidth + 17), (int) ((y+1) * cellHeight - 10));
                g.fillPolygon(polygon);

                break;
        }
    }

    public void setHoverLocation(MouseEvent event){
        setHoverLocation(Math.min(event.getX() / cellWidth, board.getWidth()-1), Math.min(event.getY() / cellHeight, board.getHeight()-1));
    }

    public void setPiece(MouseEvent event){
        setPiece(Math.min(event.getX() / cellWidth, board.getWidth()-1), Math.min(event.getY() / cellHeight, board.getHeight()-1));
    }

    private final ComponentAdapter componentAdapter = new ComponentAdapter() {
        public void componentResized(ComponentEvent e) {
            int width = getWidth();
            int height = getHeight();

            cellHeight = height / board.getHeight();
            cellWidth = width / board.getWidth();
        }
    };
}