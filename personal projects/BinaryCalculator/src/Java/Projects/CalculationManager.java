package Java.Projects;

public class CalculationManager {
    private char[][]  mainEq ;
    private final char[] equation ;
    private char[][]  tmpEq  ;

    CalculationManager (char[][] mainEq , String equation) {
        this.mainEq = mainEq ;
        this.equation = equation.toCharArray() ;
        tmpEq  = new char[mainEq.length][3] ;
    }

    private char[] simpleCal (char[][] tmpEq ) {
        short a , b , c ;
        if (tmpEq[0][1] == '|')
            for (int i = 0 ; i < tmpEq.length ; i++ ) {
                a = 
            }
    }
}
