package Everdell.Cards.TanTraveller;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;

public abstract class TravellerCritter extends Critter implements TanTraveller{
    public TravellerCritter(String name, String ability, boolean isUnqiue, int points) {
        super(name, ability, isUnqiue, points);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        action(player, game);
    }
}
