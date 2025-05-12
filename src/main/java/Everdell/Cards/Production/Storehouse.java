package Everdell.Cards.Production;

import Everdell.Locations.Location;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.ArrayList;
import java.util.TreeMap;

public class Storehouse extends ProdutionConstruction implements Location {
    private Worker worker;
    private final TreeMap<Resource, Integer> storedResources;
    private Player player;
    public Storehouse() {
        super("Storehouse", "Place 3 twigs, 2 resin, 1 stone or 2 berries on this storehouse. When visited collect all resources", false, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 1);
        worker = null;
        storedResources = new TreeMap<>();
        storedResources.put(Resource.TWIGS, 0);
        storedResources.put(Resource.RESIN, 0);
        storedResources.put(Resource.STONES, 0);
        storedResources.put(Resource.BERRIES, 0);
    }

    @Override
    public void action(Player player, Game game) {
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.TWIGS);
        resources.add(Resource.RESIN);
        resources.add(Resource.STONES);
        resources.add(Resource.BERRIES);
        Resource resource = game.getInput().getResourceFromUser(resources);
        switch (resource) {
            case TWIGS:
                storedResources.put(Resource.TWIGS, storedResources.get(Resource.TWIGS) + 3);
                break;
                case RESIN:
                    storedResources.put(Resource.RESIN, storedResources.get(Resource.RESIN) + 2);
                    break;
                    case STONES:
                        storedResources.put(Resource.STONES, storedResources.get(Resource.STONES) + 1);
                        break;
                        case BERRIES:
                            storedResources.put(Resource.BERRIES, storedResources.get(Resource.BERRIES) + 2);
                            break;
        }
    }

    @Override
    public boolean canVisit(Player player) {
        return worker == null && this.player == player;
    }

    @Override
    public void visit(Player player, Game game) {
        player.gainResources(storedResources);
        for (Resource resource : storedResources.keySet())  storedResources.put(resource, 0);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        this.player = player;
        action(player, game);
    }

    @Override
    public void returnWorker(Worker worker) {
        this.worker = null;
    }

    @Override
    public void addWorker(Worker worker) {
        this.worker = worker;
    }
    public TreeMap<Resource, Integer> getStoredResources() {return storedResources;}

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return !isOccupied() && critter instanceof Woodcarver;
    }
}
