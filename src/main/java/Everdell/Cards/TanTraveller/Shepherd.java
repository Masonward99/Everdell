package Everdell.Cards.TanTraveller;

import Everdell.Cards.Destination.Chapel;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

public class Shepherd extends TravellerCritter implements ResourcesPaidToOpponent{
    public Shepherd() {
        super("Shepherd", "Gain 3 points, then gain 1 point for each point token on your chapel. If not played for free resources paid are to an opponent", true , 1);
        getCosts().put(Resource.BERRIES, 3);
    }

    @Override
    public void action(Player player, Game game) {
        player.gainResource(Resource.BERRIES, 3);
        if (player.isCardOnBoard(new Chapel())) {
            Chapel chapel = (Chapel) player.getCardOnBoard(new Chapel());
            // gain points equal to points token on chapel. Chapel has base points of 2.
            player.gainPointTokens(chapel.getPoints() - 2);
        }
    }
}
