package Everdell.Cards.BlueGovernance;


import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.TreeMap;

public class Courthouse extends BlueGovernanceConstruction {
    public Courthouse() {
        super("Courthouse", "Gain 1 wood, resin or stone after you play a construction", true, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 2);
    }

    @Override
    public void ability(Player player, Game game) {
        ArrayList<Resource> resources= new ArrayList<>();
        resources.add(Resource.TWIGS);
        resources.add(Resource.RESIN);
        resources.add(Resource.STONES);

        Resource resource = game.getInput().getResourceFromUser(resources);
        player.gainResource(resource, 1);
    }
}
