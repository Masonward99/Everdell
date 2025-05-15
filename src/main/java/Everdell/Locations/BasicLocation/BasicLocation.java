package Everdell.Locations.BasicLocation;

import Everdell.Locations.Location;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public abstract class BasicLocation implements Location {
    private final ArrayList <Worker> workers;
    private final String name;
    public BasicLocation(String name) {
        this.name = name;
        workers = new ArrayList <>();
    }
    public void addWorker(Worker worker) {
        workers.add(worker);
    }
    public ArrayList <Worker> getWorkers() {
        return workers;
    }
    public String getName() {
        return name;
    }
    public void returnWorker(Worker worker) {
        getWorkers().remove(worker);
    }

}
