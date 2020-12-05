package Player;

import Board.property;

public class tactical extends player {

    boolean canBuy = true ;
    tactical(String name) {
        super(name);
    }

    @Override
    public void strategy(property prp) {
        boolean owned = prp.getIsOwned() ;
        player owner = prp.getOwner() ;

        if (prp.isPropertyLost() && money >= prp.getLostFieldPrice()) {
            if (canBuy){
                buyLostProperty(prp);
                canBuy = false ;
            }
            else
                canBuy = true ;
        }


        else if(!owned && money >= prp.getFieldCost()) {
                if (canBuy){
                    buyProperty(prp);
                    canBuy = false ;
                }
                else
                    canBuy = true ;
        }

        else {
            // he is not the owner
            if(!(owner == this)) {
                this.deductMoney(prp.getPenalty());
                owner.addMoney(prp.getPenalty());
            }
            // he is the owner
            else {
                if (money >= prp.getHouseCost() && !prp.isHouseExist()) {
                    if (canBuy) {
                        buyHouse(prp);
                        canBuy = false ;
                    }
                    else
                        canBuy = true ;
                }
            }
        }
    }

    @Override
    public void buyProperty(property prp) {
        prp.setOwner(this);
        deductMoney(prp.getFieldCost());
    }

    @Override
    public void buyHouse(property prp) {
        deductMoney(prp.getHouseCost());
        prp.setHouseExist();
    }

    @Override
    public void buyLostProperty(property prp) {
        prp.setOwner(this);
        deductMoney(prp.getLostFieldPrice());
    }




}
