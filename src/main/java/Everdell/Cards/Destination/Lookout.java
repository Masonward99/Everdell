package Everdell.Cards.Destination;

import Everdell.BasicLocation.Location;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Lookout extends Construction implements Destination {
    private Player player;
    private Worker worker;
    public Lookout() {
        super("Lookout", "Copy any basic or forest location", true, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean canVisit(Worker worker) {
        return worker.getPlayer() == player && this.worker == null;
    }

    @Override
    public void visit(Worker worker, Game game) {
        ArrayList<Location> locations= new ArrayList<>();
        locations.addAll(Arrays.asList(game.getBasicLocations()));
        locations.addAll(Arrays.asList(game.getForestLocations()));
        Location location = game.getInput().getLocationFromUser(locations);
        location.visit(worker, game);

    }

    @Override
    public void returnWorker(Worker worker) {
        this.worker = null;
    }

    @Override
    public void addWorker(Worker worker) {
        this.worker = worker;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return !isOccupied() && critter instanceof Wanderer;
    }
}
