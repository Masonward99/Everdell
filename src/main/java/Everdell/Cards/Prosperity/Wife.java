package Everdell.Cards.Prosperity;

import Everdell.Cards.Critter;
import Everdell.Player;
import Everdell.Resource;


public class Wife extends ProsperityCritter{
    public Wife() {
        super("Wife", "3 points at end of game if paired with husband", false, 2);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public int bonusPoints(Player player) {
        return 0;
    }
}
