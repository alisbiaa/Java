package Java.Projects;

public class EquationChecker {

    public boolean check = true ;
    private String equation  ;


    EquationChecker(String equation) {
        this.equation = equation ;
        cleanEquation();
        checkConditions();

    }

    private void cleanEquation() {
        String[] tmp = equation.split(" ") ;
        equation = "" ;
        for (String s : tmp) equation = equation + s ;
    }

    private void checkConditions() {

        char[] tmp = equation.toCharArray() ;

        //0 condition : intruder element
        for ( char c : tmp )
            if (!(isAnOperator(c) | isVariable(c) | isParenthese(c) != 0)) {
                check = false;
                break;
            }

        // 1st condition :
        int countV = 0 , countO = 0 ;

        for(char c : tmp ) {
            if (isAnOperator(c)) countO++ ;
            else if (isVariable(c)) countV ++ ;
        }
        if  (countO != countV-1) check = false ;

        //2nd condition : no consecutive
        for(int i = 0 ; i<tmp.length - 1; i++) {
            if ( isAnOperator(tmp[i])  && isAnOperator(tmp[i+1]) ) {
                check = false ;
                break ;
            }
            else if ( isVariable(tmp[i]) && isVariable(tmp[i+1]) )
            {
                check = false ;
                break ;
            }
        }

        //3rd condition : semetric parentheses
        int countOp = 0 , countCp = 0  ;
        for(char c : tmp) {
            if (isParenthese(c) == 1) countOp++;
            else if (isParenthese(c) == -1) countCp++;
        }
        if (countCp != countOp) check = false ;

        //4th condition :- &) (& () )( aa &&

        for(int i = 0 ; i < tmp.length -1 ; i++ ) {
            if( (isParenthese(tmp[i]) == 1 ) &&  isAnOperator(tmp[i+1]) ) check = false ;
            else if (isAnOperator(tmp[i]) && ( isParenthese(tmp[i+1]) == -1 )) check = false ;
            else if (isParenthese(tmp[i]) == 1 && isParenthese(tmp[i+1])== -1) check = false ;
            else if (isParenthese(tmp[i]) == -1 && isParenthese(tmp[i+1])== 1) check = false ;
            else if (isVariable(tmp[i]) && isVariable(tmp[i+1])) check = false ;
            else if (isAnOperator(tmp[i]) && isAnOperator(tmp[i+1])) check = false ;

        }

    }

    private boolean isAnOperator(char c)  {
        return c=='&' || c=='|'  ;
    }

    private boolean isVariable(char c ) {
        return   (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ;
    }

    private int isParenthese(char c) {
        if ( c == '(' ) return 1 ;
        else if ( c == ')' ) return -1 ;
        else return 0 ;
    }
}
