package Everdell.Cards.Prosperity;

import Everdell.Cards.Critter;
import Everdell.Player;
import Everdell.Resource;

public class Architect extends Critter implements Prosperity {
    public Architect() {
        super("Architect", "1 point for each unused resin or stone (max 6)", true, 2);
        getCosts().put(Resource.BERRIES, 4);
    }

    @Override
    public int bonusPoints(Player player) {
        int numResources = player.getResources().get(Resource.RESIN) + player.getResources().get(Resource.STONES);
        return Math.min(6, numResources);
    }
}
