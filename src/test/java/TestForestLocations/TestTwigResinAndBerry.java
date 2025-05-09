package TestForestLocations;

import Everdell.ForestLocations.TwigResinAndBerry;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwigResinAndBerry {
    private TwigResinAndBerry twigResinAndBerry;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twigResinAndBerry = new TwigResinAndBerry(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwigResinAndBerry() {
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(0, (int) player.getResources().get(Resource.RESIN));

        twigResinAndBerry.visit(player.nextAvailableWorker(), game);
        assertEquals(1, (int) player.getResources().get(Resource.TWIGS));
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(1, (int) player.getResources().get(Resource.RESIN));
    }
}
