package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.TreeMap;

public class Peddler extends ProductionCritter {
    public Peddler() {
        super("Peddler", "You may pay up to 2 any to gain an equal ammount of any", false, 1);
        getCosts().put(Resource.BERRIES,2 );
    }

    @Override
    public void action(Player player, Game game) {
        // count resources
        TreeMap<Resource, Integer> resources = player.getResources();
        int count = 0;
        for (Resource resource : resources.keySet()) {count += resources.get(resource);}
        System.out.println("How many resources would you like to exchange?");
        int amount = game.getInput().getIntInRange(Math.min(count, 2));
        // logic to take resources from player subject to non-negative constraint
        for (int i = 0; i < amount; i++) {
            Resource resource = game.getInput().getResourceFromUser(decidableResources(resources));
            player.gainResource(resource, -1 );
        }
        // give player resources
        game.gainAnyResource(amount, player);
    }

    private ArrayList<Resource> decidableResources(TreeMap<Resource, Integer> resources) {
        ArrayList<Resource> decidableResources = new ArrayList<>();
        for (Resource resource : resources.keySet()) {if (resources.get(resource) >0) decidableResources.add(resource);}
        return decidableResources;
    }
}
