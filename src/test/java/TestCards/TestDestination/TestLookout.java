package TestCards.TestDestination;

import Everdell.Cards.Destination.Lookout;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestLookout {
    private Lookout lookout;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        lookout = new Lookout();
        game = new Game(0);
        player = new Player("Steve");
    }

    @Test
    public void testVisit() {
        String input = "0\n1\n10\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        game = new Game(0);

        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        lookout.visit(player, game);
        assertEquals(3, (int) player.getResources().get(Resource.TWIGS));
        lookout.visit(player, game);
        assertEquals(5, (int) player.getResources().get(Resource.TWIGS));
        assertEquals(1, player.getHandSize());
    }
}
