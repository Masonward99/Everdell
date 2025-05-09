package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

public class TwoCardsAndPoint extends BasicLocation {
    public TwoCardsAndPoint() {
        super("Two Cards and Point");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return true;
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        game.drawCards(2, player);
        player.gainPointTokens(1);
    }
}
