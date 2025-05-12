package Everdell.Cards.Destination;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Worker;

import java.util.ArrayList;

public abstract class DestinationCritter extends Critter implements Destination{
    private Player player;
    private ArrayList<Worker> workers;

    public DestinationCritter(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
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
