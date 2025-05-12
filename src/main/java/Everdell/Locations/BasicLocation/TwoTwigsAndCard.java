package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class TwoTwigsAndCard extends SharedBasicLocation {
    public TwoTwigsAndCard() {
        super("Two Twigs and Card");
    }



    @Override
    public void visit(Player player, Game game) {
        game.drawCards(1, player);
        player.gainResource(Resource.TWIGS, 2);
    }

}
