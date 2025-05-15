package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Resource;
import Everdell.Player;

public class BerryAndCard extends ExclusiveBasicLocation {
    public BerryAndCard() {
        super("Berry and Card");
    }


    public void visit(Player player, Game game){
        game.drawCards(1, player);
        player.gainResource(Resource.BERRIES, 1);
    }
}
