package Everdell.Locations.ForestLocations;

import Everdell.Locations.Location;
import Everdell.Game;
import Everdell.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicLocationAndCard extends ForestLocation {
    public BasicLocationAndCard(int numPlayers) {
        super("Basic Location And Card", numPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.addAll((Arrays.asList(game.getBasicLocations())));
        Location location = game.getInput().getLocationFromUser(locations);
        location.visit(player, game);
        game.drawCards(1,player);
    }
}
