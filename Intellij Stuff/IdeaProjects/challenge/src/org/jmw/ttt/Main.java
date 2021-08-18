package org.jmw.ttt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JPanel {

    private Point clicked = null;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init(){
        JFrame frame = new JFrame();
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
                clicked = e.getPoint();
                repaint();
            }
        });
        frame.setMinimumSize(new Dimension(300, 300));
        frame.add(this);
        frame.setVisible(true);
    }

    //x=width    y=height
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(0, 90, 285, 90);
        g.setColor(Color.BLACK);
        g.drawLine(0, 170, 285, 170);
        g.setColor(Color.BLUE);
        g.drawLine(90, 0, 90, 265);
        g.setColor(Color.GREEN);
        g.drawLine(180, 0, 180, 265);
        if( clicked != null){
            g.setColor(Color.BLACK);
            g.drawLine(60 +(int) clicked.getX(),90 + (int) clicked.getY(),90 + (int) clicked.getX(),60 + (int) clicked.getY() );
            g.drawLine(57 + (int) clicked.getX(),80 + (int) clicked.getY(),57+  (int) clicked.getX(), 126+ (int) clicked.getY());
            g.drawString("Y", (int)clicked.getY(), (int) clicked.getX());
            if( clicked != null){
            g.drawString("X", (int)clicked.getX(), (int) clicked.getY());
        }
        }
    }
}