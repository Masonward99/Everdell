package Everdell.Events.BasicEvents;

import Everdell.Events.Event;
import Everdell.Game;
import Everdell.Worker;

public abstract class BasicEvent extends Event {
    public BasicEvent (String name, String requirements){
        super(name, requirements, "3 points at end of game");
    }
    public void visit(Worker worker, Game game) {
        return;
    }

    @Override
    public int getEndGamePoints() {
        return 3;
    }
}
