package creatures;

public class sponge extends Creature {
    int maxWaterLevel = 20;

    public sponge(String name , int waterLevel) {
        super(name , waterLevel);

    }

    @Override
    public void sunny() {
        this.waterLevel -= 4;
    }

    @Override
    public void cloudy() {
        this.distance += 1 ;
        this.waterLevel -= 1 ;
    }

    @Override
    public void rainy() {
        this.distance += 3 ;
        this.waterLevel += 6;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public void checkWaterLevel() {
        if (waterLevel > maxWaterLevel)
            waterLevel = maxWaterLevel;
        else if (waterLevel == 0 )
            kill() ;

    }

}
