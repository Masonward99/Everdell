package Everdell.Cards.Destination;

import Everdell.Locations.Location;
import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Lookout extends DestinationConstruction {

    public Lookout() {
        super("Lookout", "Copy any basic or forest location", true, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public void visit(Player player, Game game) {
        ArrayList<Location> locations= new ArrayList<>();
        locations.addAll(Arrays.asList(game.getBasicLocations()));
        locations.addAll(Arrays.asList(game.getForestLocations()));
        Location location = game.getInput().getLocationFromUser(locations);
        location.visit(player, game);
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return !isOccupied() && critter instanceof Wanderer;
    }
}
