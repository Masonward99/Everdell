package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;

public class TwoCardsAndAny extends ForestLocation {
    public TwoCardsAndAny(int maxPlayers) {
        super("Two Cards and Any", maxPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        game.gainAnyResource(1, player);
        game.drawCards(2, player);
    }
}
