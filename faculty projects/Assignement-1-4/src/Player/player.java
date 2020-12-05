package Player;

import Board.property;

public abstract class player {
    private final int initialMoney = 10000 ;

    private String name ;
    int money ;


    private boolean stillInGame = true ; // to check if is still in game.
    private int position = 0;
    player(String name){
        this.name = name ;
        money = initialMoney ;
    }

    public abstract void strategy(property prp) ;

    public abstract void buyProperty(property prp) ;

    public abstract void buyHouse(property prp)  ;

    public abstract void buyLostProperty(property prp) ;

    public void setPosition(int dice , int numberOfFields) {
        if (dice + position >= numberOfFields )
            position = dice + position - numberOfFields ;
        else
            position = position + dice ;
    }

    public void deductMoney(int amount) {
        money -= amount ;
    }

    public void addMoney(int amount) {
        money += amount ;
    }

    public boolean isStillInGame() {
        return stillInGame;
    }

    public int getPosition() {
        return position;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void kickPlayer() {
        stillInGame = false ;
    }
}
