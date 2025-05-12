package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Game;
import Everdell.Player;

import java.io.Serializable;

public abstract class ProductionCritter extends Critter implements Production {
    public ProductionCritter(String name, String ability, boolean isUnique, int points) {
        super(name, ability, isUnique, points);
    }

    @Override
    public void playCard(Player player, Game game) {
        super.playCard(player, game);
        this.action(player, game);
    }
}
