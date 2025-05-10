package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class GeneralStore extends Construction implements Production {
    public GeneralStore() {
        super("General Store", "Gain 1 berry. If you have a farm gain another.", false, 1);
        TreeMap<Resource,Integer> costs = getCosts();
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 1);
    }
    public void action (Player player, Game game) {
        boolean hasFarm = player.countFarms() > 0;
        player.gainResource(Resource.BERRIES, hasFarm? 2: 1);
    }
}
