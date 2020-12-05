package Java.Projects;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        String equation ;
        System.out.println("Enter your Equation \n" );
        equation = scanner.nextLine() ;
        new EquationManager(equation) ;
    }
}
