package Everdell.ForestLocations;

import Everdell.BasicLocation.Location;
import Everdell.Player;
import Everdell.Worker;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class ForestLocation implements Location {
    private final ArrayList<Worker> workers;
    private final int maxWorkers;
    private final String name;
    public ForestLocation(String name, int numPlayers) {
        this.name = name;
        maxWorkers = numPlayers == 4 ? 2: 1;
        workers = new ArrayList<>();
    }
    @Override
    public boolean canVisit(Worker worker) {
       if(workers.isEmpty()) {
           return true;
       }
       else if (workers.size() == maxWorkers) {
           return false;
       }
        return !containsPlayer(worker.getPlayer());
    }
    private boolean containsPlayer(Player player) {
        for (Worker worker : workers) {
            if (worker.getPlayer().equals(player)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Worker> getWorkers() {
        return workers;
    }
    public void returnWorker(Worker worker) {
        workers.remove(worker);
    }
    public String getName() {
        return name;
    }

}
