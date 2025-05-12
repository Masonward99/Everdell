package Everdell.Locations;


import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

public interface Location {

    public abstract boolean canVisit(Player player);
    public abstract void visit (Player player, Game game);
    public abstract void returnWorker(Worker worker);
    public abstract void addWorker(Worker worker);
}
