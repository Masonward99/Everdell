package Everdell.Cards.Destination;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Cards.Production.Doctor;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.TreeMap;

public class University extends DestinationConstruction{
    public University(){
        super("University", "Discard a critter or construction from your city. Gain resources equal to it's costs and gain 1 any and a point token", true, 3);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.RESIN, 1);
        costs.put(Resource.STONES, 2);
    }

    @Override
    public void visit(Player player, Game game) {
        ArrayList<Card> cards = new ArrayList<>(player.getBoard());
        cards.addAll(player.getPlayedNonBoardCards());
        Card card = game.getInput().getCardFromUser(cards);
        game.discardCardFromBoard(card, player);
        game.gainAnyResource(1, player);
        player.gainPointTokens(1);
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Doctor && !isOccupied();
    }
}
