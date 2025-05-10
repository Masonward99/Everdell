package Everdell;

import Everdell.BasicLocation.*;
import Everdell.Cards.Card;
import Everdell.Events.BasicEvents.*;
import Everdell.Events.Event;
import Everdell.ForestLocations.*;

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
        location.addWorker(worker);
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
    public void gainAnyResource ( int numGained, Player player) {
        Resource[] resources = new Resource[]{Resource.TWIGS, Resource.STONES, Resource.RESIN, Resource.BERRIES};
        for (int i = 0; i < numGained; i++) {
            Resource resource = getResourceFromUser( resources);
            player.gainResource(resource, 1);
        }
    }
    public Resource getResourceFromUser ( Resource[] resources) {
        System.out.println("Select a resource to gain:");
        for (int j = 0 ; j < resources.length ;j++) {
            System.out.println(j  + ": " +  resources[j].toString() );
        }
        int index = input.getIntInRange(resources.length);
        return resources[index];
    }
    public BasicLocation[] getBasicLocations() {return basicLocations;}
    public ForestLocation[] getForestLocations() {return forestLocations;}
}
