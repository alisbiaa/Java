package Java.Projects;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class EquationManager {

    private String equation ;

    private List<Character> variables = new ArrayList<>();

    private char[][] binaryTable ;

    private char[][]  mainEq ;



    public EquationManager(String equation) {
        this.equation = equation ;
        EquationChecker checker = new EquationChecker(equation) ;
        if(checker.check) {
            setVariables();
            setBinaryTable();
            setMainEq();
        }
        else System.exit(0) ;
    }

    private void setVariables() {

        for(char c : equation.toCharArray() )
            if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') )
                variables.add(c) ;

        Collections.sort(variables);

        for(int i = 0 ; i < variables.size() - 1 ; i++ )
            for(int j = i+1 ; j < variables.size() ; j++)
                if (variables.get(i) == variables.get(j)) {
                    variables.remove(j);
                    j-- ;
                }
    }

    private void setBinaryTable() {
        int cols = variables.size()  ;
        int rows = (int)Math.pow(2,variables.size()) + 1 ;

        binaryTable = new char[rows][cols] ;

        for(int i = 0 ; i < cols ; i++)
            binaryTable[0][i] = variables.get(i);

        char[] tmp ;

        for (int i = 1; i < rows; i++) {
            tmp = Integer.toBinaryString(i - 1).toCharArray();

            for (int j = cols - 1 , k = tmp.length - 1 ; j >= 0 ; j--, k--) {
                if (k>=0)
                    binaryTable[i][j] = tmp[k];
                else
                    binaryTable[i][j] = '0';
            }
        }

    }

    private void setMainEq() {
        int cols = equation.toCharArray().length ;
        int rows = (int)Math.pow(2,variables.size()) + 1 ;

        mainEq = new char[rows][cols] ; 

        int i = 0 ;
        for(char c : equation.toCharArray())  {
            mainEq[0][i] = c ;
            i++ ;
        }



        for( i = 0 ; i < cols ; i++) {
            char c = mainEq[0][i] ;
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                int indexV = variables.indexOf(c) ; //index of our variable in binaryTable
                for(int j = 1 ; j < rows ; j++)
                    mainEq[j][i] = binaryTable[j][indexV] ;
            }
        }

    }

    private void printTable(char[][] table) {
        int rows = table.length ;
        int cols = table[0].length ;

        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                char c  = table[i][j] ;
                if  (c!='0' && c!='1' && i>0)
                    System.out.print(" |");
                else
                    System.out.print(table[i][j] + "|");
            }
            System.out.println();
        }
    }

}
