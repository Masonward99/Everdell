package Everdell.Cards.Prosperity;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Theater extends Construction implements Prosperity {
    public Theater() {
        super("Theater", "1 point foe each unique critter in your city", true, 3);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 3);
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 1);
    }

    @Override
    public int bonusPoints(Player player) {
        int count = 0;
        for (Card card : player.getBoard()){
            if (card instanceof Critter && card.isUnique()){
                count++;
            }
        }
        return count;
    }
}
