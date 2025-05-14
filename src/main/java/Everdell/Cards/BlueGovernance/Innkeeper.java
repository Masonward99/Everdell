package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.security.InvalidKeyException;

public class Innkeeper extends BlueGovernanceCritter implements CardPlayingAbility {
    public Innkeeper() {
        super("Innkeeper", "When playing a critter you may discard this to decrease cost by 3 berries", true, 1);
        getCosts().put(Resource.BERRIES, 1);
    }

    @Override
    public void ability(Player player, Game game) {
        return;
    }

    @Override
    public int discount() {
        return 3;
    }

    @Override
    public void consume(Player player) {
        Innkeeper innkeeper = (Innkeeper) player.getCardOnBoard(new Innkeeper());
        player.removeCardFromBoard(innkeeper);
    }

    @Override
    public boolean canBeUsed(Player player, Card card) {
        return card instanceof Critter;
    }
}
