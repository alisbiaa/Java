package setUp;

import creatures.Creature;

public class race {
    int numberOfCompetitors ;
    char[] raceLength  ;
    Creature[] competitors ;

    public race(String raceLength, Creature[] competitors) {

        this.raceLength = new char[raceLength.length()];
        for (int i = 0 ; i < raceLength.length() ; i++){
            this.raceLength[i] = raceLength.charAt(i) ;
        }

        this.competitors = competitors ;

        numberOfCompetitors = this.competitors.length ;

    }

    public void start() {
        for (char c : raceLength) {
            for( Creature crt : competitors) {
                crt.checkWaterLevel();
                if (crt.isAlive())
                    switch (c) {
                        case 's':
                            crt.sunny();
                            break; // for a sunny day
                        case 'r':
                            crt.rainy();
                            break; // for a rainy day
                        case 'c':
                            crt.cloudy();
                            break; // for a cloudy day
                        default:
                            break;
                    }
//                System.out.println("Name : " + crt.getName() + "  WL : " + crt.getWaterLevel() + " Alive ? : " + crt.isAlive() + "   Distance " + crt.getDistance());
            }
//            System.out.println("_______");
        }

        // to get the distance covered by the winner
        int tmpDis = 0 ;
        for (Creature crt : competitors) {
            if (crt.getDistance() > tmpDis) {
                tmpDis = crt.getDistance() ;
            }
        }
        System.out.println("\n");
        System.out.println("*******      The winner(s) is(are) :     **********");

        for (Creature crt : competitors)
            if (crt.getDistance() == tmpDis)
                System.out.println(crt.getName().toUpperCase());

    }

}
