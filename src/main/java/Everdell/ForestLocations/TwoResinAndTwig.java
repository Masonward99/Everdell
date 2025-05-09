package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class TwoResinAndTwig extends ForestLocation {
    public TwoResinAndTwig(int numPlayers) {
        super("Two Resin And Twig", numPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.RESIN, 2);
        player.gainResource(Resource.TWIGS, 1);
    }
}
