package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class OneBerry extends SharedBasicLocation {
    public OneBerry() {
        super("Get One Berry Location");
    }


    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 1);
    }

}
