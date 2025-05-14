package Everdell.Cards.Destination;

import Everdell.Cards.Card;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;

public class Queen extends DestinationCritter{
    public Queen() {
        super("Queen", "Play a card worth up to 3 points for free", true, 4);
        getCosts().put(Resource.BERRIES, 5);
    }

    @Override
    public void visit(Player player, Game game) {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.addAll(player.getHand());
        cards.addAll(game.getMeadow().getCards());
        Card card = game.getInput().getCardFromUser(cards);
        while(!(card.isPlayable(player, game) && card.getPoints() <= 3) ){
            if (!card.isPlayable(player, game)) {
                System.out.println(card + " is not playable. Select a different card.");
            }
            else if (card.getPoints() > 3) {
                System.out.println(card + " Scores too many points. Select a card that scores 3 or less points.");
            }
            card = game.getInput().getCardFromUser(cards);
        }
        if(player.getHand().contains(card)) {
            player.getHand().remove(card);
            player.playCard(card, game);
        }
        else {
            game.getMeadow().discard(card);
            game.refillMeadow();
            player.playCard(card, game);
        }
    }

    @Override
    public boolean canVisit(Player player) {
        return player == getPlayer() && player.getHandSize() < 15 && getWorkers().isEmpty();
    }
}
