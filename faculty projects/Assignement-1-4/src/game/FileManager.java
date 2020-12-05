package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileManager {

    ArrayList<String> data = new ArrayList<>() ;

    int numOfFields  ;

    int numOfPlayers ;
    private String[] inputFields;

    private String[] inputPlayers ;

    public void readFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please write the name/path of the file  : ");
        String filename = scanner.nextLine();

        try {
            File myFile = new File(filename);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
            }
            if (data.size() < 1)
                System.out.println("File is empty.");
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exist.");
            System.exit(1);
        }


        numOfFields = Integer.parseInt(data.get(0));
        inputFields = new String[numOfFields];

        for (int i = 0; i < numOfFields; i++)
            inputFields[i] = data.get(i + 1).toLowerCase();

        try {
            numOfPlayers = Integer.parseInt(data.get(numOfFields + 1));
            inputPlayers = new String[numOfPlayers];
            for (int i = 0; i < numOfPlayers; i++)
                inputPlayers[i] = data.get(i + 2 + numOfFields).toLowerCase();
        }catch (NumberFormatException e){
            System.out.println("Incorrect number of fields. Please check your file again.");
            System.exit(1);
        }

        System.out.println();
        System.out.println((Arrays.toString(inputPlayers)));

    }

    public String[] getInputPlayers() {
        return inputPlayers;
    }

    public String[] getInputFields() {
        return inputFields;
    }


    public int getNumOfFields() {
        return numOfFields;
    }
}
