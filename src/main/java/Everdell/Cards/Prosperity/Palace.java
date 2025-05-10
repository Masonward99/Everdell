package Everdell.Cards.Prosperity;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Palace extends Construction implements Prosperity {
    public Palace() {
        super("Palace", "1 point for each unique construction in your city", true, 4);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 2);
        costs.put(Resource.RESIN, 3);
        costs.put(Resource.STONES, 3);
    }

    @Override
    public int bonusPoints(Player player) {
        int bonus = 0;
        for (Card card : player.getBoard()){
            if (card instanceof Construction && card.isUnique()){
                bonus++;
            }
        }
        return bonus;
    }
}
