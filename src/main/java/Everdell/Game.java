package Everdell;

import Everdell.BasicLocation.Location;
import Everdell.Cards.Card;

import java.util.ArrayList;

public class Game {
    private final Deck deck;
    private final Player[] players;
    private final ArrayList<Card> discard;
    public Game(int numPlayers) {
        deck = new Deck();
        players = new Player[numPlayers];
        discard = new ArrayList<>();
        deck.populateDeck();
    }
    public void refillDeck (){
        deck.addCards(discard);
        discard.clear();
    }
    public void drawCards(int numCards, Player player) {
        for (int i = 0; i < numCards; i++){
            if (deck.isEmpty()){
                refillDeck();
            }
            Card card = deck.drawCard();
            if (player.getHandSize() < Player.HAND_LIMIT) {
                player.addCard(card);
            }
            else {
                discard.add(card);
            }
        }
    }
    public void visitLocation (Player player, Location location) {
        Worker worker = player.nextAvailableWorker();
        location.visit(worker, this);
        worker.placeWorker(location);
        location.getWorkers().add(worker);
    }
}
