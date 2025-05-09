package Everdell.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

public class Stone extends BasicLocation {
    public Stone() {
        super("Stone");
    }

    @Override
    public boolean canVisit(Worker worker) {
        return getWorkers().isEmpty();
    }

    @Override
    public void visit(Worker worker, Game game) {
        Player player = worker.getPlayer();
        player.gainResource(Resource.STONES, 1);
    }
}
