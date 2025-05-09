package TestForestLocations;

import Everdell.ForestLocations.ThreeCardsAndStone;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestThreeCardsAndStone {
    private ThreeCardsAndStone threeCardsAndStone;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        threeCardsAndStone = new ThreeCardsAndStone(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testThreeCardsAndStone() {
        assertEquals(0, player.getHandSize());
        assertEquals(0,(int) player.getResources().get(Resource.STONES));
        threeCardsAndStone.visit(player.nextAvailableWorker(), game);

        assertEquals(3, player.getHandSize());
        assertEquals(1,(int) player.getResources().get(Resource.STONES));
    }
}
