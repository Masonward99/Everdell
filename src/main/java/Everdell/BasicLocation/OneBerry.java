package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Resource;
import Everdell.Worker;

public class OneBerry extends BasicLocation {
    public OneBerry() {
        super("Get One Berry Location");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return true;
    }

    @Override
    public void visit(Worker worker, Game game) {
        worker.getPlayer().gainResource(Resource.BERRIES, 1);
    }

}
