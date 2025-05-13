package Everdell.Cards.Destination;

import Everdell.CardPile;
import Everdell.Cards.Card;
import Everdell.Cards.Critter;
import Everdell.Cards.TanTraveller.Undertaker;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.TreeMap;

public class Cemetery extends DestinationConstruction implements WorkerNotRemovableLocation{
    public Cemetery() {
        super("Cemetery", "Reveal 4 from the deck or discard pile and play 1 for free. Discard the others", true, 0 );
        TreeMap<Resource, Integer> costs = getCosts();
        costs.put(Resource.STONES, 2);
    }

    @Override
    public void visit(Player player, Game game) {
        System.out.println("Which pile would you like to reveal from?");
        ArrayList<CardPile> piles = new ArrayList<>();
        piles.add(CardPile.DECK);
        if(!game.getDiscard().isEmpty()) piles.add(CardPile.DISCARD);
        CardPile pile = game.getInput().getCardPileFromUser(piles);
        ArrayList<Card> cards = new ArrayList<>();
        if (pile == CardPile.DISCARD) {
            cards.addAll(game.revealCardsFromDiscard(4));
        }
        else {
            cards.addAll(game.revealCardsFromDeck(4));
        }
        cards.add(null);
        Card card = game.getInput().getCardFromUser(cards);
        while (card != null && card.isPlayable(player)) {
            System.out.println(card + " is not playable. Select a different card.");
            card = game.getInput().getCardFromUser(cards);
        }
        if(card != null) {player.playCard(card, game);}
        cards.remove(card);
        // add remaining cards to discard
        for (Card c : cards) {
            if (c != null) {
                game.getDiscard().add(c);
            }
        }
    }

    @Override
    public boolean canBeOccupiedBy(Critter critter) {
        return critter instanceof Undertaker && !isOccupied();
    }

    @Override
    public boolean canVisit(Player player) {
        if(player != getPlayer()) return false;
        else if (getWorkers().isEmpty()) return true;
        else return getWorkers().size() == 1 && player.isCardOnBoard(new Undertaker());
    }
}
