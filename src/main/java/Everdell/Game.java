package Everdell;

import Everdell.BasicLocation.*;
import Everdell.Cards.Card;

import java.util.ArrayList;

public class Game {
    private final Deck deck;
    private final Player[] players;
    private final ArrayList<Card> discard;
    private final BasicLocation[] basicLocations;
    public Game(int numPlayers) {
        deck = new Deck();
        players = new Player[numPlayers];
        discard = new ArrayList<>();
        deck.populateDeck();
        basicLocations = new BasicLocation[8];
        setUpBasicLocations();
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
    private void setUpBasicLocations() {
        basicLocations[0] = new ThreeTwigs();
        basicLocations[1] = new TwoTwigsAndCard();
        basicLocations[2] = new TwoResin();
        basicLocations[3] = new ResinAndCard();
        basicLocations[4] = new TwoTwigsAndCard();
        basicLocations[5] = new Stone();
        basicLocations[6] = new BerryAndCard();
        basicLocations[7] = new BerryAndCard();
    }
}
