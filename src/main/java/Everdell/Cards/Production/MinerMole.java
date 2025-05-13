package Everdell.Cards.Production;

import Everdell.Cards.Card;
import Everdell.Game;
import Everdell.Locations.Location;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MinerMole extends ProductionCritter{
    public MinerMole() {
        // cannot copy miner mole to prevent potential infinite loop
        super("Miner Mole", "Copy 1 production in an opponents city.(cannot copy miner mole or storehouse)", false, 1 );
        getCosts().put(Resource.BERRIES,3 );
    }

    @Override
    public void action(Player player, Game game) {
        //cannot visit without viable opponents
        ArrayList<Player> possibleOpponents = findViablePlayers(player, game);
        System.out.println("Select opponent to activate a production from.");
        Player opponent = game.getInput().getPlayerFromUser(possibleOpponents);
        Card card = game.getInput().getCardFromUser(opponentsViableProductions(opponent));
        ((Production) card).action(player, game);

    }
    private ArrayList<Player> findViablePlayers(Player player, Game game) {
        // find opponent
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        Iterator<Player> iterator = players.iterator();
        while(iterator.hasNext()){
            Player p = iterator.next();
            if (p == player) iterator.remove();
            else if (opponentsViableProductions(p).isEmpty()) iterator.remove();
        }
        return players;
    }
    private ArrayList<Card> opponentsViableProductions(Player player) {
        ArrayList<Card> productions = player.getProductions();
        Iterator<Card> cardIterator = productions.iterator();
        while(cardIterator.hasNext()){
            Card c = cardIterator.next();
            if (c instanceof MinerMole) cardIterator.remove();
            else if( c instanceof Storehouse) cardIterator.remove();
        }
        return productions;
    }
}
