package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Courthouse extends Construction implements BlueGovernance {
    public Courthouse() {
        super("Courthouse", "Gain 1 wood, resin or stone after you play a construction", true, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 2);
    }

    @Override
    public void ability(Player player, Game game) {
        Resource[] resources = new Resource[]{Resource.TWIGS, Resource.RESIN, Resource.STONES};
        Resource resource = game.getResourceFromUser( resources);
        player.gainResource(resource, 1);
    }
}
