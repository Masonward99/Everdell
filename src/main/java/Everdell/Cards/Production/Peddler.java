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
        System.out.println("How many resources would you like to exchange?");
        int amount = game.getInput().getIntInRange(Math.min(player.totalResources(), 2));
        // logic to take resources from player subject to non-negative constraint
        for (int i = 0; i < amount; i++) {
            Resource resource = game.getInput().getResourceFromUser(player.getNonZeroResources());
            player.gainResource(resource, -1 );
        }
        // give player resources
        game.gainAnyResource(amount, player);
    }

}
