import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomArtPanel extends JPanel {

    private class RepaintAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    public RandomArtPanel() {
        RepaintAction action = new RepaintAction();
        Timer timer = new Timer(4000, action);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        Color randomGray = Color.getHSBColor(1.0F, 0.0F, (float) Math.random());
        g.setColor(randomGray);
        g.fillRect(0, 0, getWidth(), getHeight());
        int artType = (int) (3 * Math.random());

        switch (artType) {
            case 0:
                for (int i = 0; i < 500; i++) {
                    int x1 = (int)(getWidth() * Math.random());
                    int y1 = (int)(getHeight() * Math.random());
                    int x2 = (int)(getWidth() * Math.random());
                    int y2 = (int)(getHeight() * Math.random());
                    Color randomHue = Color.getHSBColor( (float)Math.random(), 1.0F, 1.0F);
                    g.setColor(randomHue);
                    g.drawLine(x1,y1,x2,y2);
                }
                break;
            case 1:
                for (int i = 0; i < 200; i++) {
                    int centerX =  (int)(getWidth() * Math.random());
                    int centerY = (int)(getHeight() * Math.random());
                    Color randomHue = Color.getHSBColor( (float)Math.random(), 1.0F, 1.0F);
                    g.setColor(randomHue);
                    g.drawOval(centerX - 50, centerY - 50, 100, 100);
                }
                break;
            case 2:
                for (int i = 0; i < 25; i++) {
                    int centerX =  (int)(getWidth() * Math.random());
                    int centerY = (int)(getHeight() * Math.random());
                    int size = 30 + (int)(170*Math.random());
                    Color randomColor = new Color( (int)(256*Math.random()),
                            (int)(256*Math.random()), (int)(256*Math.random()) );
                    g.setColor(randomColor);
                    g.fill3DRect(centerX - size/2, centerY - size/2, size, size, true);
                }
                break;
        }
    }
}
