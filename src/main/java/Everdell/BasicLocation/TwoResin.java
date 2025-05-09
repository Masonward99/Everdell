package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class TwoResin extends BasicLocation {
    public TwoResin() {
        super("Two Resin");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return getWorkers().isEmpty();
    }
    @Override
    public void visit(Worker worker, Game game ) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.RESIN, 2);
    }
}
