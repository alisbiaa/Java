import game.gamePanel;
import login.startPanel;
import matrixPanel.createMatrix;

import javax.swing.*;

public class Main {

    public static void main(String args[]) {
        JFrame window = new JFrame("Five In a Row");
//        createMatrix content = new createMatrix(6, 6);
        window.setContentPane(new startPanel(window));
        window.pack();
//        window.setSize(600, 480);
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
