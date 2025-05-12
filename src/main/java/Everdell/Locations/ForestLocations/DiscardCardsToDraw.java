package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;

public class DiscardCardsToDraw extends ForestLocation{
    public DiscardCardsToDraw(int numPlayers){
        super("Discard Cards to draw 2 cards for each", numPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        System.out.println("How many cards would you like to discard?");
        int numDiscarded = game.getInput().getIntInRange(player.getHandSize());
        game.discardCards(numDiscarded, player);
        game.drawCards(numDiscarded * 2 , player);
    }
}
