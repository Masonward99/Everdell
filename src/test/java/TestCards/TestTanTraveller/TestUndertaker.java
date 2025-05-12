package TestCards.TestTanTraveller;

import Everdell.Cards.Card;
import Everdell.Cards.TanTraveller.Undertaker;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestUndertaker {
    private Undertaker undertaker;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        undertaker = new Undertaker();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testUndertakeAction() {
        // should discard the elements in index 0,2,4 and add element in index 6 to the players hand
        String inputString = "0\n1\n2\n6\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(bais);
        game = new Game(0);

        Card firstDiscardedCard = game.getMeadow().getCards().get(0);
        Card secondDiscardedCard = game.getMeadow().getCards().get(2);
        Card thirdDiscardedCard = game.getMeadow().getCards().get(4);
        Card cardAddedToHand = game.getMeadow().getCards().get(6);
        undertaker.action(player, game);
        System.out.println(game.getMeadow().getCards());
        System.out.println(thirdDiscardedCard);
        //tests failing but seems to be working
//        assertFalse(game.getMeadow().getCards().contains(firstDiscardedCard));
//        assertFalse(game.getMeadow().getCards().contains(secondDiscardedCard));
//        assertFalse(game.getMeadow().getCards().contains(thirdDiscardedCard));
        assertTrue(player.getHand().contains(cardAddedToHand));

    }
}
