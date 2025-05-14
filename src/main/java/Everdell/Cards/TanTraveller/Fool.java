package Everdell.Cards.TanTraveller;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Fool extends TravellerCritter{
    public Fool() {
        super("Fool", "Play this into an empty space in an opponents city.", true, -2);
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        return;
    }

    @Override
    public boolean isPlayable(Player player, Game game) {
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player p = iterator.next();
            if (p.hasFinished()) iterator.remove();
            else if (p.isCardOnBoard(new Fool())) iterator.remove();
            else if (p.getBoard().size() >= 15) iterator.remove();
        }
        return !players.isEmpty();
    }
}
