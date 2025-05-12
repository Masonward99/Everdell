package Everdell.Cards.TanTraveller;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Wanderer extends Critter implements TanTraveller {
    public Wanderer() {
        super("Wanderer", "Draw 3 cards", false, 1);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void action(Player player, Game game) {
        game.drawCards(3,player);
    }

    @Override
    public void playCard(Player player, Game game) {
        player.addNonBoardCard(this);
        action(player, game);
    }

    @Override
    public boolean isPlayable(Player player) {
        return true;
    }
}
