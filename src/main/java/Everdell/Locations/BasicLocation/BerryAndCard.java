package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Resource;
import Everdell.Player;

public class BerryAndCard extends BasicLocation {
    public BerryAndCard() {
        super("Berry and Card");
    }

    @Override
    public boolean canVisit(Player player ) {
        return getWorkers().isEmpty();
    }

    public void visit(Player player, Game game){
        game.drawCards(1, player);
        player.gainResource(Resource.BERRIES, 1);
    }
}
