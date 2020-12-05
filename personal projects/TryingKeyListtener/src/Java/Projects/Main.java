package Java.Projects;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        panel panel = new panel() ;
        JFrame frame = new JFrame("KeyListen" ) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        frame.setResizable(false);
        frame.add(panel) ;
        frame.pack();
        frame.setLocationRelativeTo(null) ;
        frame.setVisible(true) ;

    }
}
