package Everdell.Cards.TanTraveller;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;



public class Bard extends TravellerCritter{
    public Bard() {
        super("Bard", "You may discard up to 5 cards to gain that many point tokens", true, 0);
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("How many cards would you like to discard?");
        int numCards = game.getInput().getIntInRange(Math.min(5, player.getHandSize()));
        game.discardCards(numCards, player);
        player.gainPointTokens(numCards);
    }


}
