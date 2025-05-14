package Everdell.Cards.BlueGovernance;

import Everdell.Cards.Card;
import Everdell.Player;

public interface CardPlayingAbility {
    int discount();
    void consume(Player player);
    boolean canBeUsed(Player player, Card card);
}
