package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class ThreeTwigs extends ExclusiveBasicLocation {
    public ThreeTwigs() {
        super("Three Twigs");
    }


    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.TWIGS,3 );
    }
}
