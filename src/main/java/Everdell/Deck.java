package Everdell;

import Everdell.Cards.Card;
import Everdell.Cards.Production.Farm;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> deck;
    public Deck() {
        this.deck = new ArrayList<>();
    }
    public boolean isEmpty() {
        return this.deck.isEmpty();
    }
    public Card drawCard(){
        return deck.removeLast();
    }
    public void addCards (ArrayList<Card> cards) {
        this.deck.addAll(cards);
        shuffle();
    }
    private void shuffle() {
        Collections.shuffle(deck);
    }
    public void populateDeck() {
        for (int i = 0; i < 25; i++) {
            deck.add(new Farm());
        }
        for (int i = 0; i < 3; i++) {
            deck.add(new Farm());
        }
    }
}
