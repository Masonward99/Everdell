package Everdell.Cards.Production;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Cards.Prosperity.Prosperity;
import Everdell.Cards.Prosperity.Wife;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Husband extends ProductionCritter {
    public Husband() {
        super("Husband", "Gain 1 any if paired with wife and you have at least 1 farm in city", false, 2 );
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        return;
    }

    @Override
    public void playCard(Player player, Game game) {
        boolean hasWife = player.isCardOnBoard(new Wife());
        if (hasWife) {
            Wife wife = null;
            for(Card card : player.getBoard()) {
                if (card instanceof Wife) {wife = (Wife)card; break; }
            }
            player.getBoard().remove(wife);
            HusbandAndWife husbandAndWife = new HusbandAndWife();
            player.addCard(husbandAndWife);
            husbandAndWife.action(player, game);
        }
        else player.addCard(this);
    }
}
