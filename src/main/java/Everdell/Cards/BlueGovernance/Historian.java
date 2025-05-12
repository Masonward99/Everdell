package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Historian extends BlueGovernanceCritter {
    public Historian() {
        super("Historian", "After you play a critter or construction draw a card", true, 1);
        getCosts().put(Resource.BERRIES,2 );
    }

    @Override
    public void ability(Player player, Game game) {
        game.drawCards(1, player);
    }
}
