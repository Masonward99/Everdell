package Everdell;

import Everdell.Cards.Card;

import java.util.ArrayList;


public class DiscardPile {
    private final ArrayList<Card> cards;
    public DiscardPile() {
        cards = new ArrayList<>();
    }
    public void addCard(Card card) {cards.add(card);}
    public Card getCard(){return cards.removeLast();}
    public ArrayList<Card> getCards(){return cards;}
    public void clear (){cards.clear();}
    public boolean isEmpty () {return cards.isEmpty();}
    public void discardCards(ArrayList<Card> discardedCards) {cards.addAll(discardedCards);}
}
