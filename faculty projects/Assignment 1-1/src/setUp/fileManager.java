package setUp;

import creatures.Creature;
import creatures.sandrunner;
import creatures.sponge;
import creatures.walker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class fileManager {
    ArrayList<String> data = new ArrayList<>() ;
    int numOfComp ;
    private ArrayList<Creature> competitors = new ArrayList<>();

    public void readFile() {
        try{
            Scanner scanner = new Scanner(System.in) ;
            System.out.println("Please write the name/path of the file  : ");
            String filename = scanner.nextLine() ;
            File myFile = new File (filename) ;
            if (myFile.createNewFile()) {
                System.out.println("File doesn't exist");
            }
            Scanner myReader = new Scanner(myFile) ;
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine()) ;
            }
            numOfComp = Integer.parseInt(data.get(0)) ;

            for(int i = 1; i <= numOfComp ; i++) {
                competitors.add(createCreature(data.get(i))) ;
            }
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    private Creature createCreature(String str) {
        Creature crt ;
        String[] criteria = str.split(" ") ;
        switch (criteria[1]) {
            case "r" :  {crt = new sandrunner(criteria[0], Integer.parseInt(criteria[2])) ; break ;}// sandrunner
            case "s" :  {crt = new sponge(criteria[0], Integer.parseInt(criteria[2])) ; break ; } // sponge
            case "w" :  {crt = new walker(criteria[0], Integer.parseInt(criteria[2])) ; break ; }// sponge
            default:
                throw new IllegalStateException("Unexpected value: " + criteria[1]);
        }
        return crt ;
    }

    public Creature[] getCompetitors() {
        Creature[] competitorsFin = new Creature[competitors.size()];
        for(int i=0 ; i<competitorsFin.length ; i++)
            competitorsFin[i] = competitors.get(i) ;
        return competitorsFin ;
    }

    public String getRaceLength() {
        return data.get(data.size() -1 );
    }

    public void printPlayers(){
        System.out.println("\n\n");
        System.out.println("Players : ");
        System.out.println("_____________________");
        for(Creature crt : competitors) {
            System.out.print("Name : " + crt.getName().toUpperCase()) ;
            System.out.print("\t\t\tInitial Water level : "+crt.getWaterLevel() );
            System.out.println();
            System.out.println("_____________");
        }

    }
}
