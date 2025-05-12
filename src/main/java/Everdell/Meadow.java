package Everdell;

import Everdell.Cards.Card;
import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Meadow {
    private final Card[] cards;
    public Meadow() {
        cards = new Card[8];
    }
    public void discard(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == card) {
                cards[i] = null;
            }
        }
    }
    public boolean isNotFull(){
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) return true;
        }
        return false;
    }
    public void add(Card card) {
        for (int i=0 ; i<cards.length ; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                return;
            }
    }}
    public ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < this.cards.length; i++){
            if (this.cards[i] != null) cards.add(this.cards[i]);
        }
        return cards;
    }

}
