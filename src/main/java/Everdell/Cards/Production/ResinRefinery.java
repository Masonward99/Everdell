package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class ResinRefinery extends Construction implements Production {
    public ResinRefinery() {
        super("Resin Refinery", "Gain 1 resin", false , 1);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES,1);
    }

    @Override
    public void action(Player player, Game game) {
        player.gainResource(Resource.RESIN, 1 );
    }
}
