package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class BargeToad extends ProductionCritter {
    public BargeToad() {
        super("Barge Toad", "Gain 2 twigs for each farm in your city", false, 1);
    }

    @Override
    public void action(Player player, Game game) {
        int numFarms = getPlayer().countFarms();
        player.gainResource(Resource.TWIGS, numFarms * 2);
    }

}
