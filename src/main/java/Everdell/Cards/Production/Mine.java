package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Mine extends ProdutionConstruction {
    public Mine() {
        super("Mine", "Gain 1 stone", false, 2 );
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES,1);
    }
    public void action (Player player, Game game) {
        player.gainResource(Resource.STONES, 1);
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof MinerMole && !isOccupied();
    }
}
