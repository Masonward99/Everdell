package Everdell.Cards.Prosperity;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Player;
import Everdell.Resource;

import java.util.TreeMap;

public class Castle extends Construction implements Prosperity {
    public Castle() {
        super("Castle", "1 point for each common construction", true, 4);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS, 2);
        costs.put(Resource.RESIN, 3);
        costs.put(Resource.STONES, 3);
    }

    @Override
    public int bonusPoints(Player player) {
        int bonusPoints = 0;
        for (Card card : player.getBoard()) {
            if (card instanceof Construction && !card.isUnique()) {
                bonusPoints++;
            }
        }
        return bonusPoints;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof King && !isOccupied();
    }
}
