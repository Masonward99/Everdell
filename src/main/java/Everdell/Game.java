package Everdell;

import Everdell.Cards.Card;
import Everdell.Events.BasicEvents.*;
import Everdell.Events.Event;
import Everdell.Locations.BasicLocation.*;
import Everdell.Locations.ForestLocations.*;
import Everdell.Locations.Haven;
import Everdell.Locations.Location;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private final Deck deck;
    private final Player[] players;
    private final ArrayList<Card> discard;
    private final BasicLocation[] basicLocations;
    private final ForestLocation[] forestLocations;
    private final ArrayList<Event> basicEvents;
    private final InputReader input;
    private final Meadow meadow;
    private final Haven haven;

    //constructors
    public Game(int numPlayers) {
        deck = new Deck();
        players = new Player[numPlayers];
        discard = new ArrayList<>();
        deck.populateDeck();
        basicLocations = new BasicLocation[8];
        setUpBasicLocations();
        forestLocations = new ForestLocation[4];
        setUpForestLocations(numPlayers);
        basicEvents = new ArrayList<>();
        setUpBasicEvents();
        input = new InputReader();
        meadow = new Meadow();
        refillMeadow();
        haven = new Haven();

    }
    // getters and setters
    public InputReader getInput() {return input;}

    public Meadow getMeadow() {return meadow;}

    public BasicLocation[] getBasicLocations() {return basicLocations;}

    public ForestLocation[] getForestLocations() {return forestLocations;}

    public ArrayList<Card> getDiscard() {return discard;}

    //helpers
    private void refillDeck (){
        deck.addCards(discard);
        discard.clear();
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

    private void setUpForestLocations(int numPlayers) {
        ArrayList<ForestLocation> forestLocations = new ArrayList<>();
        Random rand = new Random();
        forestLocations.add(new ForestThreeBerries(numPlayers));
        forestLocations.add(new ThreeCardsAndStone(numPlayers));
        forestLocations.add(new TwoCardsAndAny(numPlayers));
        forestLocations.add(new TwoAny(numPlayers));
        forestLocations.add(new TwoBerriesAndCard(numPlayers));
        forestLocations.add(new TwigResinAndBerry(numPlayers));
        forestLocations.add(new TwoResinAndTwig(numPlayers));
        forestLocations.add(new BasicLocationAndCard(numPlayers));
        for(int i =0; i< (numPlayers == 2? 3 : 4); i++){
            ForestLocation forestLocation = forestLocations.get(rand.nextInt(forestLocations.size()));
            this.forestLocations[i] = forestLocation;
            forestLocations.remove(forestLocation);
        }
    }

    private void setUpBasicEvents() {
        basicEvents.add(new CityMonument());
        basicEvents.add(new GrandTour());
        basicEvents.add(new HarvestFestival());
        basicEvents.add(new CartographersExpedition());
    }

    //Methods related to meadow
    public void drawFromMeadow(Player player) {
        Card card = input.getCardFromUser(meadow.getCards());
        meadow.discard(card);
        addCardToPlayer(player, card);
        refillMeadow();
    }

    public void discardFromMeadow() {
        Card card = input.getCardFromUser(meadow.getCards());
        meadow.discard(card);
        discard.add(card);
    }

    //Card drawing
    public Card drawCard(){
        if (deck.isEmpty()){
            refillDeck();
        }
        return deck.drawCard();
    }

    public void refillMeadow(){
        while (meadow.isNotFull()){meadow.add(drawCard());}
    }

    public void addCardToPlayer(Player player, Card card){
        if (player.getHandSize() < Player.HAND_LIMIT) {
            player.addCard(card);
        }
        else {
            discard.add(card);
        }
    }

    public void drawCards(int numCards, Player player) {
        for (int i = 0; i < numCards; i++) addCardToPlayer(player, drawCard());

    }

    public ArrayList<Card> revealCards(int numCards) {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) cards.add(drawCard());
        return cards;
    }

    //locations
    public void visitLocation (Player player, Location location) {
        Worker worker = player.nextAvailableWorker();
        location.visit(player, this);
        worker.placeWorker(location);
        location.addWorker(worker);
    }

    //resources
    public void gainAnyResource ( int numGained, Player player) {
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(Resource.TWIGS);
        resources.add(Resource.RESIN);
        resources.add(Resource.STONES);
        resources.add(Resource.BERRIES);
        for (int i = 0; i < numGained; i++) {
            Resource resource = input.getResourceFromUser( resources);
            player.gainResource(resource, 1);
        }
    }

    public void discardCards(int numCards, Player player) {
        for (int i = 0; i < numCards; i++){
            Card card = input.getCardFromUser(player.getHand());
            player.removeCardFromHand(card);
            discard.add(card);
        }
    }
}
