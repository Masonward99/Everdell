package Everdell.Cards.TanTraveller;

import Everdell.Game;
import Everdell.Locations.Location;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.ArrayList;
import java.util.Iterator;

public class Ranger extends TravellerCritter{
    public Ranger(){
        super("Ranger", "Move 1 of your deployed workers to a new location. Unlocks second dungeon", true, 1);
        getCosts().put(Resource.BERRIES,2 );
    }

    @Override
    public void action(Player player, Game game) {
        ArrayList<Worker> redeployableWorkers = player.getRedeployableWorkers();
        System.out.println("Select worker to redeploy");
        Worker selectedWorker = game.getInput().getWorkerFromUser(redeployableWorkers);
        System.out.println("Select location to redeploy");
        Location selectedLocation = game.getInput().getLocationFromUser(game.getVisitableLocations(player));
        selectedWorker.returnWorker();
        game.visitLocation(player, selectedLocation);
    }

    @Override
    public boolean isPlayable(Player player, Game game) {
        if (player.isCardOnBoard(new Ranger())) return false;
        return !player.getRedeployableWorkers().isEmpty();
    }
}
