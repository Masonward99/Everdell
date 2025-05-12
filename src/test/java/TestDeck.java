import Everdell.Deck;
import Everdell.Cards.Card;
import Everdell.Cards.Production.Farm;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class TestDeck {
    private Deck deck;
    @Before
    public void setUp() {
        deck = new Deck();
    }
    @Test
    public void testAddCard() {
        assert(deck.isEmpty());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Farm());
        deck.addCards(cards);
        assertFalse(deck.isEmpty());
    }

    @Test
    public void testDrawCard (){
        assert(deck.isEmpty());
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Farm());
        deck.addCards(cards);
        assert(deck.drawCard() instanceof Farm);
        assert(deck.isEmpty());
    }
    @Test
    public void testPopulate(){
        deck.populateDeck();
        for (int i=0; i< 28; i++){
            assertFalse (deck.isEmpty());
            deck.drawCard();
        }
        assert(deck.isEmpty());
    }
}
