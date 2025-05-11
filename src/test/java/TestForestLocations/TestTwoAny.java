package TestForestLocations;

import Everdell.ForestLocations.TwoAny;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestTwoAny {
    private TwoAny twoAny;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoAny = new TwoAny(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoAny() {
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));

        String input = "0\n3\n";
        ByteArrayInputStream in  = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game = new Game(0);

        twoAny.visit(player.nextAvailableWorker(), game);

        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(1, (int) player.getResources().get(Resource.TWIGS));
    }
}
