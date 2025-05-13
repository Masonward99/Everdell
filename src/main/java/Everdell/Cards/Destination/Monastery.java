package Everdell.Cards.Destination;

import Everdell.Cards.Critter;
import Everdell.Cards.Production.Monk;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Monastery extends DestinationConstruction implements WorkerNotRemovableLocation{
    public Monastery(){
        super("Monastery", "Give 2 any to an opponent and gain 4 point tokens", true, 1);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 1);
        costs.put(Resource.BERRIES, 1);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public void visit(Player player, Game game) {
        System.out.println("Choose opponent to give resources");
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        players.remove(player);
        Player opponent = game.getInput().getPlayerFromUser(players);
        for (int i=0; i < 2; i ++){
            Resource resource = game.getInput().getResourceFromUser(player.getNonZeroResources());
            player.gainResource(resource, -1);
            opponent.gainResource(resource, 1);
        }
        player.gainPointTokens(4);
    }

    @Override
    public boolean canVisit(Player player) {
        if (player != getPlayer()) return false;
        else if (player.totalResources() < 2) return false;
        else if (getWorkers().isEmpty()) return true;
        return (getWorkers().size() == 1 && player.isCardOnBoard(new Monk()));
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Monk && !isOccupied();
    }
}
