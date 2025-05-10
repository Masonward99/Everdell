package Everdell;

import Everdell.BasicLocation.*;
import Everdell.Cards.Card;

import java.util.ArrayList;
import java.util.Scanner;

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
    public void gainAnyResource ( int numGained, Player player) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numGained; i++) {
            Resource resource = getResourceFromUser(scanner);
            player.gainResource(resource, 1);
        }
    }
    public Resource getResourceFromUser (Scanner scanner) {
        Resource[] resources = new Resource[]{Resource.BERRIES, Resource.RESIN, Resource.STONES, Resource.TWIGS} ;
            System.out.println("Select a resource to gain:");
            for (int j = 0 ; j < resources.length ;j++) {
                System.out.println(j  + ": " +  resources[j].toString() );
            }
            int index = getIntInRange(resources.length, scanner);
            return resources[index];
    }

    private int getIntInRange ( int max, Scanner scanner ) {
        int index = scanner.nextInt();
        while ( index >= max){
            System.out.println("Enter a number between 0 and " + max);
            index = scanner.nextInt();
        }
        return index;
    }
}
