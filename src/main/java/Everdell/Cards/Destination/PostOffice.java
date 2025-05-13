package Everdell.Cards.Destination;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.PostalPigeon;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class PostOffice extends DestinationConstruction{
    public PostOffice(){
        super("Post Office", "Give an opponent 2 cards, then discard any number of cards and draw up to your hand limit.", false, 2);
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.TWIGS,1);
        costs.put(Resource.RESIN,2);
    }

    @Override
    public void visit(Player player, Game game) {
        if (getPlayer() != player) getPlayer().gainPointTokens(1);
        System.out.println("Select an opponent to give cards.");
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        players.remove(player);
        Player opponent = game.getInput().getPlayerFromUser(players);
        for (int i = 0; i < 2; i++){
            Card card = game.getInput().getCardFromUser(player.getHand());
            player.removeCardFromHand(card);
            game.addCardToPlayer(opponent, card);
        }
        System.out.println("How many cards would you like to discard?");
        int numDiscarded = game.getInput().getIntInRange(player.getHandSize());
        for(int i = 0; i < numDiscarded; i++){
            Card card = game.getInput().getCardFromUser(player.getHand());
            player.removeCardFromHand(card);
        }
        game.refillHand(player);
    }

    @Override
    public boolean canVisit(Player player) {
        return getWorkers().isEmpty() && player.getHandSize() >= 2;
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof PostalPigeon && !isOccupied();
    }
}
