package game;

import Board.board;
import Board.lucky;
import Board.property;
import Board.service;
import Player.players;
import Player.player;
import java.util.ArrayList;

public class Monopoly implements Game {

    ArrayList<player> playersList;
    ArrayList<Object> listOfFields ;

    int numberOfFields ;

    // constructer that auto start the game.
    public Monopoly(){
        FileManager file = new FileManager() ;
        file.readFile();
        String[] inputFields = file.getInputFields();
        String[] inputPlayers = file.getInputPlayers() ;
        numberOfFields = file.getNumOfFields()  ;
        this.listOfFields = new board(inputFields).getListOfFields() ;
        this.playersList = new players(inputPlayers).getPlayersList() ;
        start();
    }

    // to start the game
    @Override
    public void start(){
        int i = 0 ;
        while (check()){
            for(player plr : playersList){
                if (plr.isStillInGame()) {
                    int dice = (int) (Math.random() * (6 - 1 + 1) + 1); // int i = (int) (Math.random() * (max - min + 1) + min)
                    plr.setPosition(dice, numberOfFields);
                    Object field = listOfFields.get(plr.getPosition());
                    update(plr, field);
                    System.out.println("Player : " + plr.getName() + " | position : "  + plr.getPosition() + " | money : " + plr.getMoney());
                }
            }
            i++ ;
            System.out.println("_____________________ round : " + i + "___________");
        }
        whoIsTheWinner() ;



    }

    // check if the game is over (one player did last)
    @Override
    public boolean check() {
        int index = 0 ;
        for(player plr : playersList)
            if (plr.isStillInGame()) index++ ;
        return index>1 ;
    }

    // to update the game
    @Override
    public void update(player plr, Object field) {
        if (plr.isStillInGame()) {
            if (field.getClass() == property.class) plr.strategy((property) field) ;
            else if (field.getClass() == lucky.class) plr.addMoney( ((lucky) field).getFreeMoney());
            else plr.deductMoney( ( (service) field).getPenalty());
        }

        if (plr.getMoney() <= 0) {
            plr.kickPlayer();
            lostProperties(plr);
        }
    }

    // to make all the fields of a losing player free
    private void lostProperties(player plr) {
        for (Object field : listOfFields)
            if(field.getClass() == property.class && ((property) field).getOwner() == plr)
                ((property) field).setPropertyLost();
    }

    private void whoIsTheWinner() {
        player tmp = null;
        for(player plr : playersList)
            if (plr.isStillInGame())  tmp = plr  ;

        System.out.println("THE WINNER IS : ");
        System.out.println("Name : " +  tmp.getName().toUpperCase());
        System.out.println("Money  : " +  tmp.getMoney());
        System.out.println("Owned properties number : ");
        for(Object prp : listOfFields)
            if ( prp.getClass() == property.class && ((property) prp).getOwner() == tmp )
                System.out.print(" " + ((property) prp).getFieldPosition() + "|");
    }

}
