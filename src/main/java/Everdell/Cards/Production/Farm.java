package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.Prosperity.Wife;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Farm extends ProdutionConstruction{
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


    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return (critter instanceof Husband || critter instanceof Wife) && !isOccupied();
    }
}
