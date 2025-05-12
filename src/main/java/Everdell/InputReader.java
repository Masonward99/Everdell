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
    public Card getCardOrNull(ArrayList<Card> cards) {
        if (cards.isEmpty()) return null;
        if(cards.size() == 1) return cards.getFirst();
        cards.add(null);
        System.out.println("Select a card:");
        for (int j = 0 ; j < cards.size() ;j++) {
            System.out.println(j  + ": " +  cards.get(j).toString() );
        }
        int index = getIntInRange(cards.size());
        return cards.get(index);
    }

}
