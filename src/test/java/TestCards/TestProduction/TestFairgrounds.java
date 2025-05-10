package TestCards.TestProduction;

import Everdell.Cards.Production.Fairgrounds;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFairgrounds {
    Fairgrounds fairgrounds;
    Player player;
    Game game;
    @Before
    public void setUp() {
        fairgrounds = new Fairgrounds();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testFairgrounds() {
        assertEquals(0, player.getHandSize());
        fairgrounds.action(player, game);
        assertEquals(2, player.getHandSize());
    }

    @Test
    public void testFairgroundsUnique() {
        assertTrue(fairgrounds.testUniqueConstraint(player));
        player.addCardToBoard(new Fairgrounds());
        assertFalse(fairgrounds.testUniqueConstraint(player));
    }
}
