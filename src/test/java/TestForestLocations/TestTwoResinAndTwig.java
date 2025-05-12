package TestForestLocations;

import Everdell.Locations.ForestLocations.TwoResinAndTwig;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwoResinAndTwig {
    private TwoResinAndTwig twoResinAndTwig;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        twoResinAndTwig = new TwoResinAndTwig(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoResinAndTwig() {
        assertEquals(0, (int)player.getResources().get(Resource.RESIN));
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));

        twoResinAndTwig.visit(player, game);
        assertEquals(2, (int)player.getResources().get(Resource.RESIN));
        assertEquals(1, (int)player.getResources().get(Resource.TWIGS));
    }
}
