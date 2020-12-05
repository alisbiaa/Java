import setUp.fileManager;
import setUp.race;

import java.util.Scanner;

public class main {

    public static void main (String[] args) {
        fileManager file = new fileManager() ;
        file.readFile();
        file.printPlayers();
        race race = new race(file.getRaceLength() , file.getCompetitors()) ;
        race.start();
    }
}
