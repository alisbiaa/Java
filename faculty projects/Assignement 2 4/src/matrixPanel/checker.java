package matrixPanel;


import java.awt.*;

public class checker {

    private int player = 0 ;
    private int[][] table ;
    private int rows ;
    private int x ;
    private int y ;

// i = y || x = j

    public checker(createBox[][] boxesList, Point coords) {
        rows = boxesList.length ;
        render(boxesList);

        this.x = (int) coords.getX();
        this.y = (int) coords.getY();
        this.player = table[y][x]  ;

    }

    private void render(createBox[][] boxesList) {
        table = new int[rows][rows] ;
        for(int i= 0 ; i< rows ; i++)
            for (int j = 0 ; j< rows; j++)
                table[i][j] = boxesList[i][j].getPlayer() ;
    }

    public int result() {
        return  Math.max(Math.max(dia_check_1(), dia_check_2()), Math.max(ver_check(), hori_check()));
    }

    private int dia_check_1() {
        int count = 0 ;
        for(int i= y , j = x ; i>=0 && j>=0; i-- , j--) {
            if (table[i][j] == player) count++;
            else break ;
        }
        count-- ;
        for(int i= y , j = x ; i<rows && j<rows ; i++ , j++) {
            if (table[i][j] == player) count++;
            else break ;
        }
        return count ;
    }

    private int dia_check_2() {
        int count = 0 ;
        for(int i= y , j = x ; i<rows && j>=0; i++ , j--) {
            if (table[i][j] == player) count++;
            else break ;
        }
        count-- ;
        for(int i= y , j = x ; i>=0 && j<rows ; i-- , j++) {
            if (table[i][j] == player) count++;
            else break ;
        }
        return count ;
    }

    private int ver_check() {
        int count = 0 ;
        for(int i= y , j = x ; i>=0 ; i--) {
            if (table[i][j] == player) count++;
            else break ;
        }
        count-- ;
        for(int i= y , j = x ; i<rows ; i++) {
            if (table[i][j] == player) count++;
            else break ;
        }
        return count ;
    }

    private int hori_check() {
        int count = 0;
        for (int i = y, j = x; j >= 0 ; j--) {
            if (table[i][j] == player) count++;
            else break;
        }
        count--;
        for (int i = y, j = x; j < rows ; j++) {
            if (table[i][j] == player) count++;
            else break;
        }
        return count;
    }

//    private void printTable() {
//        for(int i= 0 ; i< rows ; i++) {
//            System.out.println();
//            for (int j = 0; j < rows; j++)
//                System.out.print(table[i][j] + " | ");
//        }
//    }



}
