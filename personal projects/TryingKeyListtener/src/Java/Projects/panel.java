package Java.Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class panel extends JPanel implements KeyListener {

    JTextField keyText = new JTextField(80) ;
    JLabel l = new JLabel("Press fire button")  ;

    panel() {
        keyText.addKeyListener(this)  ;
        BorderLayout layout = new BorderLayout() ;
        setLayout(layout) ;
        add(l, BorderLayout.NORTH) ;
        add(keyText, BorderLayout.SOUTH) ;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int a = e.getKeyCode() ;
        l.setText("typed" + a ) ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //int a = e.getKeyCode() ;
        //l.setText(""+ a)  ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int a = e.getKeyCode() ;
        l.setText("released"+ a)  ;
    }
}
