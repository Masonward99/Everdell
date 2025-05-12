package TestBasicLocations;

import Everdell.Locations.BasicLocation.ThreeTwigs;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestThreeTwigs {
    private ThreeTwigs threeTwigs;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        threeTwigs = new ThreeTwigs();
        game = new Game(0);
        player = new Player("Steve");
    }

    @Test
    public void testThreeTwigs() {
        assertEquals (0, (int) player.getResources().get(Resource.TWIGS));
        threeTwigs.visit(player,game);
        assertEquals (3, (int) player.getResources().get(Resource.TWIGS));
    }

    @Test
    public void testCanVisit (){
        assertTrue(threeTwigs.canVisit(player));
        game.visitLocation(player,threeTwigs);
        assertFalse(threeTwigs.canVisit(player));
    }
}
