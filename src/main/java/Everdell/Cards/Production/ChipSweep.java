package Everdell.Cards.Production;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Iterator;

public class ChipSweep extends ProductionCritter {
    public ChipSweep() {
        super("Chip Sweep", "Activate 1 production in your city", false, 2);
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        ArrayList<Card> productions = getPlayer().getProductions();
        Iterator<Card> iterator = productions.iterator();
        while (iterator.hasNext()) {
            Card production = iterator.next();
            if (production instanceof ChipSweep) iterator.remove();
        }
        System.out.println(productions);
        Card card = game.getInput().getCardFromUser(productions);
        if(card != null) ((Production) card).action(player, game);
    }

}
