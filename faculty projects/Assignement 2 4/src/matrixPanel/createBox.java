package matrixPanel;

import matrixPanel.createMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createBox extends JButton implements ActionListener {
    private final Color red = Color.RED;
    private final Color blue = Color.blue;
    private final Color gray = Color.gray;

    boolean active = false ;

    createMatrix matrix ;
    private Point coords ;

    private int player = 0 ;

    public createBox(int x , int y , createMatrix matrix) {
        coords = new Point(x,y) ;
        this.matrix = matrix ;
        setBackground(gray);
        addActionListener(this);
        setSize(40,40);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(matrix.getTurn() == 1  && !active) {
            setBackground(blue);
            active = true ;
            player = 1 ;
            matrix.update(this);
            matrix.setTurn();
        }
        else if (matrix.getTurn() == 2  && !active){
            setBackground(red);
            active = true ;
            player =  2 ;
            matrix.update(this);
            matrix.setTurn();
        }
    }

    public int getPlayer() {
        return player;
    }

    public Point getCoords() {
        return coords;
    }

    public void reset() {
        setBackground(gray);
        active = false ;
        player = 0 ;
    }

    public boolean isActive() {
        return active;
    }
}
