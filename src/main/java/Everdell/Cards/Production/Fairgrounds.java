package Everdell.Cards.Production;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.TreeMap;

public class Fairgrounds extends Construction implements Production {
    public Fairgrounds() {
        super("Fairgrounds", "Draw 2 cards", true, 3);
        TreeMap<Resource, Integer> resources = getCosts();
        resources.put(Resource.TWIGS, 1);
        resources.put(Resource.RESIN, 2);
        resources.put(Resource.STONES, 1);
    }

    @Override
    public void action(Player player, Game game) {
        game.drawCards(2, player);
    }

    @Override
    public boolean testUniqueConstraint(Player player) {
        ArrayList<Card> board = player.getBoard();
        for (Card card : board) {
            if (card instanceof Fairgrounds) {
                return false;
            }
        }
        return true ;
    }
}
