package game;

import Player.player;

public interface Game {

    //to start the game
    void start();

    // check if the game is over (one player did last)
    boolean check();

    // to update the game
    void update(player plr, Object field);
}
