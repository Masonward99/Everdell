package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Innkeeper extends BlueGovernanceCritter implements Discounter {
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
}
