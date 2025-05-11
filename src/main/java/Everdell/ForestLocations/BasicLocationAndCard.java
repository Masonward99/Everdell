package Everdell.ForestLocations;

import Everdell.BasicLocation.Location;
import Everdell.Game;
import Everdell.Worker;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicLocationAndCard extends ForestLocation {
    public BasicLocationAndCard(int numPlayers) {
        super("Basic Location And Card", numPlayers);
    }

    @Override
    public void visit(Worker worker, Game game) {
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll((Arrays.asList(game.getBasicLocations())));
        Location location = game.getInput().getLocationFromUser(locations);
        location.visit(worker, game);
        game.drawCards(1, worker.getPlayer());
    }
}
