package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class TwigResinAndBerry extends ForestLocation {
    public TwigResinAndBerry(int numPlayers) {
        super("Twig, Resin And Berry", numPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.BERRIES,1);
        player.gainResource(Resource.TWIGS,1);
        player.gainResource(Resource.RESIN, 1);
    }
}
