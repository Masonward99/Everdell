package Everdell.Cards.TanTraveller;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;

public abstract class TravellerCritter extends Critter implements TanTraveller{
    public TravellerCritter(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        action(player, game);
    }
}
