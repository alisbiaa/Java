package Player;

import Board.property;

public class careful extends player {

    careful(String name) {
        super(name);
    }

    @Override
    public void strategy(property prp) {
        int allowance = money / 2 ;
        boolean owned = prp.getIsOwned() ;
        player owner = prp.getOwner() ;

        // // if it is a lost field ( was owned by someone who lost the game)
        if (prp.isPropertyLost() && allowance >= prp.getLostFieldPrice() )
            buyLostProperty(prp);

        // if none owns the property
        else if (!owned && allowance > prp.getFieldCost())
            buyProperty(prp);

        else{
            // if he is not the owner
            if (! (owner == this) ) {
                deductMoney(prp.getPenalty());
                owner.addMoney(prp.getPenalty());
            }
            // if he is the owner
            else if(allowance > prp.getHouseCost() && !prp.isHouseExist()){
                buyHouse(prp);
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
