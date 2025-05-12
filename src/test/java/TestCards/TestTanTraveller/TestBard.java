package TestCards.TestTanTraveller;

import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.ResinRefinery;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.Prosperity.EverTree;
import Everdell.Cards.TanTraveller.Bard;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class TestBard {
    private Bard bard;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        bard = new Bard();
        game = new Game(0);
        player = new Player("Steve");
    }

    @Test
    public void testTanTraveller() {
        String inputString = "2\n1\n4\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(bais);
        game = new Game(0);

        Farm farm = new Farm();
        Architect architect = new Architect();
        Castle castle = new Castle();
        player.addCard(farm);
        player.addCard(architect);
        player.addCard(new EverTree());
        player.addCard(new ResinRefinery());
        player.addCard(new ResinRefinery());
        player.addCard(castle);
        assertEquals(0, player.getPointTokens());
        assertTrue(player.getHand().contains(farm));
        assertTrue(player.getHand().contains(architect));
        assertTrue(player.getHand().contains(castle));
        bard.action(player, game);
        assertTrue(player.getHand().contains(farm));
        assertFalse(player.getHand().contains(architect));
        assertFalse(player.getHand().contains(castle));
        assertEquals(2, player.getPointTokens());
    }

}
