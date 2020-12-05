import javax.swing.*;

public class main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        RandomArtPanel content = new RandomArtPanel();
        window.setContentPane(content);
        window.setSize(600,400);
        window.setLocation(100, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}
