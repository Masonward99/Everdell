package Everdell.Cards.Production;

import Everdell.Cards.AbilityCard;
import Everdell.Game;
import Everdell.Player;

public interface Production extends AbilityCard {
    public abstract void action(Player player, Game game);
}
