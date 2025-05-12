package Everdell.Cards.Production;

import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class GeneralStore extends ProdutionConstruction {
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

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Shopkeeper && !isOccupied();
    }


}
