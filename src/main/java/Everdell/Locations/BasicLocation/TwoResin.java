package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class TwoResin extends ExclusiveBasicLocation {
    public TwoResin() {
        super("Two Resin");
    }

    @Override
    public void visit(Player player, Game game ) {
        player.gainResource(Resource.RESIN, 2);
    }
}
