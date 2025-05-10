package TestCards.TestDestination;

import Everdell.Cards.Destination.Chapel;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestChapel {
    private Chapel chapel;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        chapel = new Chapel();
        game = new Game(0);
        player = new Player("Steve");
    }

    @Test
    public void testChapel() {
        assertEquals(0, player.getHandSize());
        chapel.visit(player.nextAvailableWorker(), game);
        assertEquals(2, player.getHandSize());
        chapel.visit(player.nextAvailableWorker(), game);
        assertEquals(6, player.getHandSize());
        assertEquals(4, chapel.getPoints());
    }
}
