package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class ThreeCardsAndStone extends ForestLocation {
    public ThreeCardsAndStone(int numPlayers) {
        super("Three Cards And Stone", numPlayers);
    }
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.STONES, 1);
        game.drawCards(3, player);
    }
}
