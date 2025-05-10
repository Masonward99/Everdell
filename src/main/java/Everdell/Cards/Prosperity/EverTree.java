package Everdell.Cards.Prosperity;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class EverTree extends Construction implements Prosperity {
    public EverTree() {
        super("Ever Tree", "1 point for each prosperity card in your city", true, 5);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 3);
        costs.put(Resource.STONES, 3);
        costs.put(Resource.RESIN, 3);
    }

    @Override
    public int bonusPoints(Player player) {
        int bonusPoints = 0;
        for (Card card : player.getBoard()){
            if (card instanceof Prosperity){
                bonusPoints += 1;
            }
        }
        return bonusPoints;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return !isOccupied();
    }
}
