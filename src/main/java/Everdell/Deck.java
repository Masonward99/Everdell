package Everdell;

import Everdell.Cards.BlueGovernance.Historian;
import Everdell.Cards.BlueGovernance.Innkeeper;
import Everdell.Cards.BlueGovernance.Shopkeeper;
import Everdell.Cards.Card;
import Everdell.Cards.Destination.*;
import Everdell.Cards.Production.*;
import Everdell.Cards.Prosperity.*;
import Everdell.Cards.TanTraveller.*;

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
        for (int i = 0; i < 8; i++) {
            deck.add(new Farm());
        }
        for (int i = 0; i < 4; i++) {
            deck.add(new Husband());
            deck.add(new Wife());
        }
        for (int i = 0; i < 3; i++) {
            deck.add(new Teacher());
            deck.add(new Wanderer());
            deck.add(new Shopkeeper());
            deck.add(new Historian());
            deck.add(new GeneralStore());
            deck. add(new BargeToad());
            deck.add(new Innkeeper());
            deck.add(new ChipSweep());
            deck.add(new Peddler());
            deck.add(new Storehouse());
            deck.add(new Woodcarver());
            deck.add(new PostalPigeon());
            deck.add(new TwigBarge());
            deck.add(new ResinRefinery());
            deck.add(new Ruins());
            deck.add(new MinerMole());
            deck.add(new PostOffice());
        }
        for (int i = 0; i < 2; i++) {
            deck.add(new EverTree());
            deck.add(new Architect());
            deck.add(new King());
            deck.add(new Castle());
            deck.add(new Lookout());
            deck.add(new Doctor());
            deck.add(new Bard());
            deck.add(new Theater());
            deck.add(new Undertaker());
            deck.add(new Queen());
            deck.add(new Palace());
            deck.add(new School());
            deck.add(new University());
            deck.add(new Monk());
            deck.add(new Monastery());
            deck.add(new Cemetery());
        }
        shuffle();
    }
}
