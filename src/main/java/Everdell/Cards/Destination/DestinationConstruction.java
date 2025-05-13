package Everdell.Cards.Destination;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public abstract class DestinationConstruction extends Construction implements Destination {
    private Player player;
    private final ArrayList<Worker> workers;

    public DestinationConstruction(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
        workers = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }


    public ArrayList<Worker> getWorkers() {return workers;}
    public boolean canVisit(Player player) {
        return this.player == player && getWorkers().isEmpty();
    }

    @Override
    public void addWorker(Worker worker) {
        getWorkers().add(worker);
    }

    @Override
    public void returnWorker(Worker worker) {
        getWorkers().remove(worker);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        this.player = player;
    }
}
