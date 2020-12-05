package creatures;

public class sandrunner extends Creature {
    int maxWaterLevel = 8;

    public sandrunner(String name , int waterLevel) {
        super(name , waterLevel);
    }

    @Override
    public void sunny() {
        this.distance += 3 ;
        this.waterLevel -= 1;
    }

    @Override
    public void cloudy() {
        this.distance += 1 ;
    }

    @Override
    public void rainy() {
        this.waterLevel += 3 ;
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

        if (waterLevel > maxWaterLevel) waterLevel = maxWaterLevel;
        else if (waterLevel == 0 ) super.kill() ;

    }


}
