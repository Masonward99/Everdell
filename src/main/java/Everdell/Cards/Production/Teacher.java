package Everdell.Cards.Production;

import Everdell.Cards.Card;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;

import java.util.ArrayList;
import java.util.Arrays;


public class Teacher extends ProductionCritter {
    public Teacher() {
        super("Teacher", "Draw 2 cards keep 1 and give the other to an opponent", false, 2);
        getCosts().put(Resource.BERRIES, 2);
    }

    @Override
    public void action(Player player, Game game) {
        ArrayList<Player> players = new ArrayList<>(Arrays.asList(game.getPlayers()));
        players.remove(player);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(game.drawCard());
        cards.add(game.drawCard());
        System.out.println("Select a card to keep:");
        Card card = game.getInput().getCardFromUser(cards);
        if (players.size() > 1 ) {
            System.out.println("Select opponent to give other card to");
        }
        Player opponent = game.getInput().getPlayerFromUser(players);
        game.addCardToPlayer(player, card);
        cards.remove(card);
        game.addCardToPlayer(opponent, cards.getFirst());
    }
}
