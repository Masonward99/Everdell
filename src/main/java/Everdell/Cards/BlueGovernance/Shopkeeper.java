package Everdell.Cards.BlueGovernance;


import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Shopkeeper extends BlueGovernanceCritter {
    public Shopkeeper() {
        super("Shopkeeper", "Gain 1 berry after you play a critter", true, 1);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void ability(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 1);
    }
}
