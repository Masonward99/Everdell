package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class TwoBerriesAndCard extends ForestLocation {
    public TwoBerriesAndCard(int maxPlayers) {
        super("Two Berries And Card", maxPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.BERRIES, 2);
        game.drawCards(1,player);
    }
}
