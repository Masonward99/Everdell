package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class TwigBarge extends Construction implements Production {
    public TwigBarge() {
        super("Twig Barge", "Gain 2 twigs", false, 1);
        TreeMap<Resource, Integer> costs= getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public void action(Player player, Game game) {
        player.gainResource(Resource.TWIGS, 2);
    }

    public boolean canBeOccupiedBy (Critter critter) {
        return critter instanceof BargeToad && !isOccupied();
    }


    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        action(player, game);
    }

}
