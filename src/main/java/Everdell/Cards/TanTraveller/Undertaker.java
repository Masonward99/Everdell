package Everdell.Cards.TanTraveller;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Undertaker extends TravellerCritter {
    public Undertaker() {
        super("Undertaker", "Discard 3 cards from the meadow, refill, then draw 1 from meadow. Unlocks second cemetery location", true, 1 );
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("Select 3 cards from the meadow to discard:");
        for (int i = 0; i < 3; i++) game.discardFromMeadow();
        game.refillMeadow();
        System.out.println("Select card to add to hand:");
        game.drawFromMeadow(player);
    }

}
