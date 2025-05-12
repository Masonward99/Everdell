package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;

public class TwoAny extends ForestLocation {
    public TwoAny(int maxPlayers) {
        super("Two Any", maxPlayers);
    }
    public void visit(Player player, Game game) {
        game.gainAnyResource(2, player);
    }
}
