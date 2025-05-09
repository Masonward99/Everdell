package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class TwoTwigsAndCard extends BasicLocation {
    public TwoTwigsAndCard() {
        super("Two Twigs and Card");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return true;
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        game.drawCards(1, player);
        player.gainResource(Resource.TWIGS, 2);
    }

}
