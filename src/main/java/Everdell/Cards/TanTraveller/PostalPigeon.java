package Everdell.Cards.TanTraveller;

import Everdell.Cards.Card;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;

public class PostalPigeon extends TravellerCritter {
    public PostalPigeon() {
        super("PostalPigeon", "Reveal 2 cards. You may play one that scores less than 3 points for free. Discard the other.", false, 1);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void action(Player player, Game game) {
        System.out.println("Select card to play");
        ArrayList<Card> cards = game.revealCardsFromDeck(2);
        cards.add(null);
        Card card = game.getInput().getCardFromUser(cards);
        while (card != null && !(card.isPlayable(player, game) && card.getPoints() <= 3) ) {
            System.out.println(card + " is not playable select another card");
            card = game.getInput().getCardFromUser(cards);
        }
        if (card != null) {
            player.playCard(card, game);
        }
        //discard other cards
        for (Card c : cards) {
            if(c != null && c != card) game.getDiscard().add(c);
        }
    }
}
