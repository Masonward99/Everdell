package Everdell.Cards.Prosperity;

import Everdell.Cards.Card;
import Everdell.Cards.Construction;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.HusbandAndWife;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.TreeMap;

public class School extends ProsperityConstruction {
    public School() {
        super("School", "1 point for each common critter in your city", true, 2);
        TreeMap<Resource, Integer> resources = getCosts();
        resources.put(Resource.TWIGS, 2);
        resources.put(Resource.RESIN, 2);
    }

    @Override
    public int bonusPoints(Player player) {
        int bonus = 0;
        ArrayList<Card> cards = new ArrayList<>();
        cards.addAll(player.getBoard());
        cards.addAll(player.getPlayedNonBoardCards());
        for (Card card : cards) {
            if (card instanceof HusbandAndWife) bonus += 2;
            else if (card instanceof Critter && !card.isUnique()) bonus += 1;
        }
        return bonus;
    }
}
