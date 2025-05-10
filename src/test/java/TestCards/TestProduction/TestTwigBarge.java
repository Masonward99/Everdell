package TestCards.TestProduction;

import Everdell.Cards.Production.TwigBarge;
import Everdell.Cards.Production.BargeToad;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTwigBarge {
    private TwigBarge twigBarge;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        twigBarge = new TwigBarge();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwigBarge() {
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        twigBarge.action(player, game);
        assertEquals(2, (int) player.getResources().get(Resource.TWIGS));
    }

    @Test
    public void testCanBeOccupiedBy (){
        assertTrue(twigBarge.canBeOccupiedBy(new BargeToad()));
        twigBarge.setOccupied();
        assertFalse(twigBarge.canBeOccupiedBy(new BargeToad()));
    }
}
