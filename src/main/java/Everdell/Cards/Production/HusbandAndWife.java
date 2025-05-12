package Everdell.Cards.Production;

import Everdell.Cards.Critter;
import Everdell.Cards.Prosperity.Prosperity;
import Everdell.Game;
import Everdell.Player;

public class HusbandAndWife extends Critter implements Prosperity, Production {
    public HusbandAndWife() {
        super("Husband and wife", "Gain 3 bonus points at the end of game. If you have a farm also gain 1 any", false, 4);
    }

    @Override
    public void action(Player player, Game game) {
        game.gainAnyResource(1, player);
    }

    @Override
    public int bonusPoints(Player player) {
        return 3;
    }

}
