package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class ResinAndCard extends BasicLocation {
    public ResinAndCard() {
        super("Resin and Card");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return true;
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        game.drawCards(1,player);
        player.gainResource(Resource.RESIN, 1);
    }
}
