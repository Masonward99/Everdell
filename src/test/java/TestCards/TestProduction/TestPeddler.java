package TestCards.TestProduction;

import Everdell.Cards.Production.Peddler;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestPeddler {
    private Peddler peddler;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        peddler = new Peddler();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testPeddler() {
        //replaces a twig with a stone
        String inputString = "1\n1\n2\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(bais);
        game = new Game(0);
        player.gainResource(Resource.TWIGS, 3 );
        player.gainResource(Resource.STONES, 3 );
        player.gainResource(Resource.RESIN, 3 );
        peddler.action(player, game);
        assertEquals(2, (int) player.getResources().get(Resource.TWIGS));
        assertEquals(4, (int) player.getResources().get(Resource.STONES));

    }
}
