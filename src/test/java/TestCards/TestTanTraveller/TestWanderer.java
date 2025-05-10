package TestCards.TestTanTraveller;

import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWanderer {
    private Wanderer wanderer;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        wanderer = new Wanderer();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testAction(){
        assertEquals(0, player.getHandSize());
        wanderer.action(player, game);
        assertEquals(3, player.getHandSize());
        wanderer.action(player, game);
        wanderer.action(player, game);
        assertEquals(8, player.getHandSize());
    }

}
