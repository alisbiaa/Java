package creatures;

public class walker extends Creature {
    int maxWaterLevel = 12;

    public walker(String name , int waterLevel) {
        super(name , waterLevel);
    }

    @Override
    public void sunny() {
        this.distance += 1 ;
        this.waterLevel -= 2 ;
    }

    @Override
    public void cloudy() {
        this.distance += 2 ;
        this.waterLevel -= 1 ;
    }

    @Override
    public void rainy() {
        this.distance += 1 ;
        this.waterLevel += 3  ;
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
