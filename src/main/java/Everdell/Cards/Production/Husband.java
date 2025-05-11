package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Husband extends Critter implements Production {
    public Husband() {
        super("Husband", "Gain 1 any if paired with wife and you have at least 1 farm in city", false, 2 );
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        return;
    }
}
