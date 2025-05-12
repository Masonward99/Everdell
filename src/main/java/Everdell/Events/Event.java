package Everdell.Events;

import Everdell.Locations.Location;
import Everdell.Worker;

public abstract class Event implements Location{
    private final String requirements;
    private final String name;
    private final String reward;
    private Worker worker;
    public Event(String requirements, String name, String reward) {
        this.requirements = requirements;
        this.name = name;
        this.reward = reward;
        worker = null;
    }
    public abstract int getEndGamePoints();

    @Override
    public void returnWorker(Worker worker) {
        this.worker = null ;
    }
    public void addWorker(Worker worker) {
        this.worker = worker;
    }
    public String getRequirements() {
        return requirements;
    }
    public String getName() {
        return name;
    }
    public String getReward() {
        return reward;
    }
}
