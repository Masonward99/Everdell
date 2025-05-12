package Everdell.Locations.ForestLocations;

import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class TwoBerriesAndCard extends ForestLocation {
    public TwoBerriesAndCard(int maxPlayers) {
        super("Two Berries And Card", maxPlayers);
    }

    @Override
    public void visit(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 2);
        game.drawCards(1,player);
    }
}
