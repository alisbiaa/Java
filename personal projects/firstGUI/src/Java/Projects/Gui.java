package Java.Projects;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {

    int count = 0  ;
    JFrame frame ;
    JPanel panel ;
    JButton button ;
    JLabel label ;

    Gui () {
        frame = new JFrame() ;
        button = new JButton("Click me") ;
        label = new JLabel() ;
        button.addActionListener(this) ;


        panel = new JPanel() ;
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button) ;
        panel.add(label) ;

        frame.add(panel,BorderLayout.CENTER) ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("First GUI");
        frame.pack();
        frame.setVisible(true);





    }

    public static void main(String[] args) {
         new Gui() ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++ ;
        label.setText("Number of Clicks : " + count );
    }
}
