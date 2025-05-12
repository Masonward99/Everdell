package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class ForestThreeBerries extends ForestLocation {
    public ForestThreeBerries(int maxPlayers) {
        super("Three Berries", maxPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 3 );
    }
}
