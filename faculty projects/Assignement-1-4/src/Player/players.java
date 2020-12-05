package Player;

import java.util.ArrayList;
import java.util.Arrays;

public class players {
    private final ArrayList<player> playersList = new ArrayList<>() ;
    private String[] inputList ;

    public players(String[] inputList) {
        this.inputList = inputList ;

        createPlayers();
    }

    private void createPlayers(){
        try {
            for (String str : inputList) {
                // input should be "PlayerNAME g|c|t (field type)"
                String[] player = str.split(" ");
                switch (player[1]) {
                    case "g":
                        playersList.add(new greedy(player[0]));
                        break;// player[0] is player name
                    case "c":
                        playersList.add(new careful(player[0]));
                        break;
                    case "t":
                        playersList.add(new tactical(player[0]));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + player[1] + "STRATEGY should be G | C | T ! ");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect number of players. Please check your file again.");
            System.exit(1);
        }
    }


    public ArrayList<player> getPlayersList() {
        return playersList;
    }
}
