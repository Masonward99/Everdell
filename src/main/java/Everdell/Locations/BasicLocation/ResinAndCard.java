package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class ResinAndCard extends SharedBasicLocation {
    public ResinAndCard() {
        super("Resin and Card");
    }



    @Override
    public void visit(Player player, Game game) {
        game.drawCards(1,player);
        player.gainResource(Resource.RESIN, 1);
    }
}
