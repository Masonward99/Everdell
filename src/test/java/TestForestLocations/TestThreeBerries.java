package TestForestLocations;

import Everdell.Locations.ForestLocations.ForestThreeBerries;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestThreeBerries {
    private ForestThreeBerries forestThreeBerries;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        forestThreeBerries = new ForestThreeBerries(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testThreeBerries() {
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        forestThreeBerries.visit(player, game);
        assertEquals(3, (int) player.getResources().get(Resource.BERRIES));
    }
    @Test
    public void testCanVisit (){
        assertTrue(forestThreeBerries.canVisit(player));
        game.visitLocation(player,forestThreeBerries);
        Player player2 = new Player("Alan");
        assertFalse(forestThreeBerries.canVisit(player2));
    }
    @Test
    public void testCanVisitWith4Players(){
        forestThreeBerries = new ForestThreeBerries(4);
        assertTrue(forestThreeBerries.canVisit(player));
        game.visitLocation(player,forestThreeBerries);
        //same player cannot visit again
        assertFalse(forestThreeBerries.canVisit(player));
        //different player can visit
        Player player2 = new Player("Alan");
        assertTrue(forestThreeBerries.canVisit(player2));
    }
}
