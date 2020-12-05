import javax.swing.*;

public class Snake  extends JFrame {

    public Snake() {
        add(new Board(this));
//        setResizable(false);
        pack();
        setTitle("Snake game");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
