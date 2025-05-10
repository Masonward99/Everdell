package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Farm extends Construction implements Production {
    public Farm() {
        super("Farm", "Gain one berry", false, 1);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS,2);
        costs.put(Resource.RESIN, 1);
    }

    @Override
    public void action(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 1);
    }
}
