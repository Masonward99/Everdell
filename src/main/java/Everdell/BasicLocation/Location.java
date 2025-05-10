package Everdell.BasicLocation;

import Everdell.Game;

import Everdell.Worker;

import java.util.ArrayList;


public interface Location {

    public abstract boolean canVisit(Worker worker);
    public abstract void visit (Worker worker, Game game);
    public abstract void returnWorker(Worker worker);
    public abstract void addWorker(Worker worker);
}
