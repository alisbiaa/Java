import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {
    private int SCORE = 0 ;
    private final JFrame container ;

    private final int B_WIDTH = 600;
    private final int B_HEIGHT = 600;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int[] X = new int[ALL_DOTS];
    private final int[] Y = new int[ALL_DOTS];

    private int dots;
    private int food_x;
    private int food_y;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image food;
    private Image head;

    public Board(JFrame container) {
        this.container = container;
        addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImg();
        initGame();
    }
    private void loadImg() {
        ImageIcon iib = new ImageIcon(getClass().getResource("/icons/head.png"));
        ball = iib.getImage();

        ImageIcon iih = new ImageIcon(getClass().getResource("/icons/head.png"));
        head = iih.getImage();

        ImageIcon iif = new ImageIcon(getClass().getResource("/icons/cake.png"));
        food = iif.getImage();
    }

    private void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            X[i] = 100 - i * 10;
            Y[i] = 100 ;
        }
        locateApple();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void locateApple() {
        int random = (int) (Math.random() * RAND_POS);
        food_x = random * DOT_SIZE;
        random = (int) (Math.random() * RAND_POS);
        food_y = random * DOT_SIZE;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(food, food_x, food_y,DOT_SIZE, DOT_SIZE, this);
            for (int i = 0; i < dots ; i++) {
                if (i == 0)
                    g.drawImage(head, X[i], Y[i],DOT_SIZE, DOT_SIZE,  this);
                else
                    g.drawImage(ball, X[i], Y[i],DOT_SIZE, DOT_SIZE,  this);
            }
            Toolkit.getDefaultToolkit().sync();
        }
        else
            gameOver(g);
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over ! ";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics mtr = getFontMetrics(small);
        g.setColor(Color.BLACK);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - mtr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(msg ,0,0);

        new GameOverFrame(SCORE, this).setVisible(true);
        container.dispose();
    }

    private void checkFood() {
        if (X[0] == food_x && Y[0] == food_y) {
            dots++;
            locateApple();
            SCORE++ ;
        }
    }

    private void move() {
        for (int i = dots; i > 0 ; i--) {
            X[i] = X[i - 1];
            Y[i] = Y[i - 1];
        }
        if (leftDirection) {
            X[0] -= DOT_SIZE;
        }
        if (rightDirection) {
            X[0] += DOT_SIZE;
        }
        if (upDirection) {
            Y[0] -= DOT_SIZE;
        }
        if (downDirection) {
            Y[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {
        // if the snake eats itself
        for (int i = dots ; i > 0 ; i--) {
            if ((i > 4) && (X[0] == X[i]) && (Y[0] == Y[i])) {
                inGame = false;
                break;
            }
        }
        // if snakes hits the borders
        if (Y[0] >= B_HEIGHT || Y[0] < 0)
            inGame = false;

        if (X[0] >= B_WIDTH || X[0] < 0)
            inGame = false;

        if (!inGame) {
            timer.stop();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkFood();
            checkCollision();
            move();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !rightDirection) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if (key == KeyEvent.VK_RIGHT && !leftDirection) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if (key == KeyEvent.VK_UP && !downDirection) {
                upDirection = true;
                leftDirection = false;
                rightDirection = false;
            }

            if (key == KeyEvent.VK_DOWN && !upDirection) {
                downDirection = true;
                leftDirection = false;
                rightDirection = false;
            }
        }
    }

}
