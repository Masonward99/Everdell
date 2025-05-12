package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;

public class DiscardToGainAny extends ForestLocation{
    public DiscardToGainAny(int numPlayers) {
        super("Discard up to 3 cards to gain that many resources",numPlayers );
    }

    @Override
    public void visit(Player player, Game game) {
        System.out.println("How many cards would you like to discard?");
        int numDiscarder = game.getInput().getIntInRange(Math.min(3, player.getHandSize()));
        game.discardCards(numDiscarder, player);
        game.gainAnyResource(numDiscarder, player);
    }
}
