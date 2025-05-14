package Everdell;

import Everdell.Cards.Card;
import Everdell.Locations.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;
    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public int getIntInRange ( int max ) {
        int index = scanner.nextInt();
        while ( index >= max){
            System.out.println("Enter a number between 0 and " + max);
            index = scanner.nextInt();
        }
        return index;
    }
    public Resource getResourceFromUser ( ArrayList<Resource> resources) {
        System.out.println("Select a resource to gain:");
        for (int j = 0 ; j < resources.size() ;j++) {
            System.out.println(j  + ": " +  resources.get(j).toString() );
        }
        int index = getIntInRange(resources.size());
        return resources.get(index);
    }
    public Card getCardFromUser (ArrayList<Card> cards) {
        if (cards.isEmpty()) return null;
        if(cards.size() == 1) return cards.getFirst();
        System.out.println("Select a card:");
        for (int j = 0 ; j < cards.size() ;j++) {
            if (cards.get(j) != null){
                System.out.println(j  + ": " +  cards.get(j).toString() );
            }else{
                System.out.println(j  + ": " +  "no card selected" );
            }
        }
        int index = getIntInRange(cards.size());
        return cards.get(index);
    }
    public Location getLocationFromUser (ArrayList<Location> locations) {
        if (locations.isEmpty()) return null;
        if (locations.size() == 1) return locations.getFirst();
        System.out.println("Select a location:");
        for (int j = 0 ; j < locations.size() ;j++) {
            System.out.println(j  + ": " + locations.get(j).toString() );
        }
        int index = getIntInRange(locations.size());
        return locations.get(index);
    }
    public String getPlayerName (){
        return scanner.next();
    }
    public Player getPlayerFromUser (ArrayList<Player> players) {
        if (players.isEmpty()) return null;
        if (players.size() == 1) return players.get(0);
        System.out.println("Select a player:");
        for (int j = 0 ; j < players.size() ;j++) {
            System.out.println(j  + ": " + players.get(j).toString() );
        }
        int index = getIntInRange(players.size());
        return players.get(index);
    }
    public CardPile getCardPileFromUser (ArrayList<CardPile> cardPiles) {
        if (cardPiles.isEmpty()) return null;
        if (cardPiles.size() == 1) return cardPiles.getFirst();
        System.out.println("Select a card pile:");
        for (int j = 0 ; j < cardPiles.size() ;j++) {
            System.out.println(j  + ": " +  cardPiles.get(j).toString() );
        }
        int index = getIntInRange(cardPiles.size());
        return cardPiles.get(index);
    }

    /**
     * Ask a yes or no question to a user. If they answer yes return true
     * @return true if user answers yes, false otherwise
     */
    public boolean getYesOrNo () {
        char c = scanner.next().charAt(0);
        while (c != 'y' && c != 'Y' && c != 'n' && c != 'N') {
           System.out.println("Enter Y or N: ");
           c = scanner.next().charAt(0);
        }
        return (c == 'y' || c == 'Y');
    }

    public Worker getWorkerFromUser (ArrayList<Worker> workers) {
        if (workers.isEmpty()) return null;
        if (workers.size() == 1) return workers.getFirst();
        System.out.println("Select a worker:");
        for (int j = 0 ; j < workers.size() ;j++) {
            System.out.println(j  + ": " + workers.get(j).getLocation().toString() );
        }
        int index = getIntInRange(workers.size());
        return workers.get(index);
    }

}
