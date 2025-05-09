package TestBasicLocations;

import Everdell.BasicLocation.Stone;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestStones {
    private Stone stone;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        stone = new Stone();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testStones() {
        assertEquals((int) player.getResources().get(Resource.STONES), 0);

        stone.visit(player.nextAvailableWorker(), game);
        assertEquals((int) player.getResources().get(Resource.STONES), 1);
    }

    @Test
    public void canVisit(){
        assertTrue(stone.canVisit(player.nextAvailableWorker()));
        game.visitLocation(player, stone);
        assertFalse(stone.canVisit(player.nextAvailableWorker()));
    }
}
