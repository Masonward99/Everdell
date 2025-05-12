package Everdell.Cards.Production;

import Everdell.Cards.Construction;
import Everdell.Game;
import Everdell.Player;

public abstract class ProdutionConstruction extends Construction implements Production {
   public ProdutionConstruction(String name, String ability, boolean isUnique, int points) {
       super(name, ability, isUnique, points);
   }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        this.action(player, game);
    }
}
