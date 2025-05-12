package Everdell.Locations.BasicLocation;

import Everdell.Game;
import Everdell.Player;

public class TwoCardsAndPoint extends SharedBasicLocation {
    public TwoCardsAndPoint() {
        super("Two Cards and Point");
    }



    @Override
    public void visit(Player player, Game game) {
        game.drawCards(2, player);
        player.gainPointTokens(1);
    }
}
