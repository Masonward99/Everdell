package Everdell.Cards.Production;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Monk extends ProductionCritter{
    public Monk() {
        super("Monk", "You may give up to 2 berries to an opponent to gain 2 point tokens for each. Unlocks second monastery location." ,true, 0);
        getCosts().put(Resource.BERRIES,1 );
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("How many berries would you like to give?");
        int berries = game.getInput().getIntInRange(Math.min(player.getResources().get(Resource.BERRIES), 2));
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        players.remove(player);
        if (berries == 0) return;
        if (players.size() > 1) System.out.println("Select player to give berries");
        Player opponent = game.getInput().getPlayerFromUser(players);
        opponent.gainResource(Resource.BERRIES, berries);
        player.gainResource(Resource.BERRIES, -berries);
        player.gainPointTokens(berries * 2);
    }
}
