package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class TwoResinAndTwig extends ForestLocation {
    public TwoResinAndTwig(int numPlayers) {
        super("Two Resin And Twig", numPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.RESIN, 2);
        player.gainResource(Resource.TWIGS, 1);
    }
}
