package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Resource;
import Everdell.Worker;
import Everdell.Player;

public class BerryAndCard extends BasicLocation {
    public BerryAndCard() {
        super("Berry and Card");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return getWorkers().isEmpty();
    }

    public void visit(Worker worker, Game game){
        Player player = worker.getPlayer();
        game.drawCards(1, player);
        player.gainResource(Resource.BERRIES, 1);
    }
}
