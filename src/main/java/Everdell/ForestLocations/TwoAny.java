package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

public class TwoAny extends ForestLocation {
    public TwoAny(int maxPlayers) {
        super("Two Any", maxPlayers);
    }
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        game.gainAnyResource(2, player);
    }
}
