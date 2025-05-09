package TestBasicLocations;

import Everdell.BasicLocation.TwoResin;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTwoResin {
    private TwoResin twoResin;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoResin = new TwoResin();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoResin() {
        assertEquals(0, (int) player.getResources().get(Resource.RESIN));

        twoResin.visit(player.nextAvailableWorker(), game);
        assertEquals(2, (int) player.getResources().get(Resource.RESIN));
    }

    @Test
    public void testCanVisit(){
        assertTrue(twoResin.canVisit(player.nextAvailableWorker()));
        game.visitLocation(player, twoResin);
        assertFalse(twoResin.canVisit(player.nextAvailableWorker()));
    }
}
