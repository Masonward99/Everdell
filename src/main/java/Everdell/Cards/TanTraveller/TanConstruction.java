package Everdell.Cards.TanTraveller;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;

public abstract class TanConstruction extends Construction implements TanTraveller {
    public TanConstruction(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        action(player, game);
    }
}
