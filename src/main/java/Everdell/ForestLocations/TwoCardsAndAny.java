package Everdell.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

public class TwoCardsAndAny extends ForestLocation {
    public TwoCardsAndAny(int maxPlayers) {
        super("Two Cards and Any", maxPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        game.gainAnyResource(1, player);
        game.drawCards(2, player);
    }
}
