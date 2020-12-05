package matrixPanel;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class createMatrix extends JPanel {
    private int rows ;
    private int cols ;
    private createBox[][] boxesList ;
    private int turn = 1 ; // to see which player turn it is
    private boolean gameOver = false ;
    private int gameStatus = 0  ; // to announce who's the winnier


    public createMatrix(int rows , int cols ){
        this.rows = rows ;
        this.cols = cols ;
        boxesList = new createBox[rows][cols];
        start();
    }

    private void start() {
        setLayout(new GridLayout(rows,cols,5,10));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(int i= 0 ; i< rows ; i++)
            for (int j = 0 ; j< cols ; j++) {
                createBox tmp = new createBox(j, i, this) ;
                add(tmp);
                boxesList[i][j] = tmp ;
            }
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0,width,height);
    }

    public void update(createBox box){
//        System.out.println("turn : " + turn);
       int result = new checker(boxesList, box.getCoords()).result();
       fix(result);

       if(result >= 5 ) {
            gameOver = true ;
            gameStatus = turn ;
       }
       boolean tmp = true ;
       for(int i = 0 ; i< rows ; i++) {
           for (int j = 0; j < rows; j++)
               tmp = tmp && boxesList[i][j].isActive();
       }
       if (tmp)
           gameOver = true ;

       if(gameOver) {
           JOptionPane.showMessageDialog(null, "Game over.\n Winner is player : " + gameStatus);
           reset();
       }

    }

    private void fix(int result) {
        int x = 0 ;
        if (result == 3 ) x = 1 ;
        else if (result== 4) x = 2 ;
        for (int k = 0; k < x ; k++) {
            ArrayList<createBox> temporary = new ArrayList<>();
            if (turn == 1) {
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < rows; j++)
                        if (boxesList[i][j].getPlayer() == turn) temporary.add(boxesList[i][j]);
                int random_ind = (int) (Math.random() * (temporary.size()) + 0); // generate a random index
                temporary.get(random_ind).reset();
            } else if (turn == 2) {
                for (int i = 0; i < rows; i++)
                    for (int j = 0; j < rows; j++)
                        if (boxesList[i][j].getPlayer() == turn) temporary.add(boxesList[i][j]);
                int random_ind = (int) (Math.random() * (temporary.size()) + 0); // generate a random index
                temporary.get(random_ind).reset();
            }
        }

    }
    public void reset() {
        turn = 1 ;
        gameOver = false ;
        gameStatus = 0 ;
            for(int i= 0 ; i< rows ; i++)
                for (int j = 0 ; j< rows; j++)
                    boxesList[i][j].reset();
    }

    public void setTurn() {
        if (turn == 1) turn  = 2 ;
        else if (turn == 2 ) turn = 1 ;
    }

    public int getTurn() {
        return turn;
    }

}
