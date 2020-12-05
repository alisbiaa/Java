package Board;

import Player.player;

public class property {
    private final int fieldCost = 1000 ;
    private final int houseCost = 4000 ;
    private final int penalty = 500 ;
    private final int penaltyHouse = 2000 ; // 2000 in case of house presence ;
    private int lostFieldPrice ;

    private player owner ;

    private int fieldPosition ;
    private boolean isOwned = false ;
    private boolean houseExist = false ;
    private boolean propertyLost = false ;


    public property(int fieldPosition) {
        this.fieldPosition = fieldPosition ;
    }

    public void setHouseExist() {
        houseExist = true ;
    }

    public void setOwner(player owner) {
        this.owner = owner;
        isOwned = true;
    }

    public boolean isHouseExist() {
        return houseExist;
    }

    public boolean getIsOwned() {
        return isOwned;
    }

    public player getOwner() {
        return owner;
    }

    public int getFieldCost() {
        return fieldCost;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public int getPenalty() {
        return houseExist ? penaltyHouse : penalty ;
    }

    public void setPropertyLost() {
        propertyLost = true ;
        isOwned = false ;
        if (houseExist)
            lostFieldPrice = fieldCost + houseCost ;
        else
            lostFieldPrice = fieldCost ;
    }

    public boolean isPropertyLost() {
        return propertyLost;
    }

    public int getLostFieldPrice() {
        return lostFieldPrice;
    }

    public int getFieldPosition() {
        return fieldPosition;
    }
}
