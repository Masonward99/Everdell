package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class TwigResinAndBerry extends ForestLocation {
    public TwigResinAndBerry(int numPlayers) {
        super("Twig, Resin And Berry", numPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.BERRIES,1);
        player.gainResource(Resource.TWIGS,1);
        player.gainResource(Resource.RESIN, 1);
    }
}
