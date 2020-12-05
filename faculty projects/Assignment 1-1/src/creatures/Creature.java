package creatures;

public abstract class Creature {
    String name ;
    int waterLevel  ; //Initial water level
    int distance = 0 ;
    private boolean living = true ;


    public Creature(String name, int waterLevel) {
        this.name = name;
        this.waterLevel = waterLevel;
    }

    public abstract void sunny() ;
    public abstract void cloudy() ;
    public abstract void rainy() ;
    public abstract String getName() ;
    public abstract int getDistance() ;
    public abstract void checkWaterLevel() ;

    public boolean isAlive() {
        return living ;
    }

    public void kill() {
        living = false ;
    }
    public int getWaterLevel(){
        return waterLevel ;
    }

}
