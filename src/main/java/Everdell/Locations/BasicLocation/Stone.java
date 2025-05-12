package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Stone extends ExclusiveBasicLocation {
    public Stone() {
        super("Stone");
    }



    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.STONES, 1);
    }
}
