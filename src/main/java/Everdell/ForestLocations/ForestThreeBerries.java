package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class ForestThreeBerries extends ForestLocation {
    public ForestThreeBerries(int maxPlayers) {
        super("Three Berries", maxPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.BERRIES, 3 );
    }
}
