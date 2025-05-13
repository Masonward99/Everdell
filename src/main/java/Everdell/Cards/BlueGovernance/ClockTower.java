package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Locations.BasicLocation.BasicLocation;
import Everdell.Locations.ForestLocations.ForestLocation;
import Everdell.Locations.Location;
import Everdell.Player;
import Everdell.Resource;
import Everdell.Worker;

import java.util.ArrayList;
import java.util.TreeMap;

public class ClockTower extends BlueGovernanceConstruction{
    private int pointTokens;
    public ClockTower(){
        super("Clock Tower",
                "When played, place 3 point tokens here. At the start of preparing for season you may activate this to pay 1 point token to activate a basic or forest location where you have a worker deployed.",
                true,
                0);
        pointTokens = 0;
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 3);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public void ability(Player player, Game game) {
        System.out.println("Would you like to pay one point token from here to activate a basic or forest location where you have a worker deployed?");
        boolean activated = game.getInput().getYesOrNo();
        if(activated){
            pointTokens -= 1;
            Location location = game.getInput().getLocationFromUser(basicOrForestLocationsWithWorker(player));
            location.visit(player, game);
        }
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        pointTokens = 3;
    }
    public boolean canUseAbility(Player player){
        ArrayList<Worker> workers = new ArrayList<>(player.getWorkers());
        for (Worker worker : workers) {
            if (worker.getLocation() instanceof BasicLocation || worker.getLocation() instanceof ForestLocation) return true;
        }
        return false;
    }
    private ArrayList<Location> basicOrForestLocationsWithWorker (Player player){
        ArrayList<Location> locations = new ArrayList<>();
        for (Worker worker : player.getWorkers()) {
            if (worker.getLocation() instanceof BasicLocation || worker.getLocation() instanceof ForestLocation) locations.add(worker.getLocation());
        }
        return locations;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Historian && !isOccupied();
    }

    @Override
    public int getPoints() {
        return super.getPoints() + pointTokens;
    }
}
