package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class ThreeCardsAndStone extends ForestLocation {
    public ThreeCardsAndStone(int numPlayers) {
        super("Three Cards And Stone", numPlayers);
    }
    public void visit(Player player, Game game) {
        player.gainResource(Resource.STONES, 1);
        game.drawCards(3, player);
    }
}
