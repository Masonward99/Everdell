package Everdell.Cards.Production;

import Everdell.Cards.AbilityCard;
import Everdell.Game;
import Everdell.Player;

public  interface Production extends AbilityCard {
      void action(Player player, Game game);
}
