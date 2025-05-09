package TestForestLocations;

import Everdell.ForestLocations.TwoCardsAndAny;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestTwoCardsAndAny {
    private TwoCardsAndAny twoCardsAndAny;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoCardsAndAny = new TwoCardsAndAny(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoCardsAndAny() {
        String inputString = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        assertEquals(0, (int)player.getResources().get(Resource.RESIN));
        assertEquals(0, player.getHandSize());

        twoCardsAndAny.visit(player.nextAvailableWorker(), game);
        assertEquals(2, player.getHandSize());
        assertEquals(1, (int)player.getResources().get(Resource.RESIN));
    }
}
