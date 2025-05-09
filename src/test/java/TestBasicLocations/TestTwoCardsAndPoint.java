package TestBasicLocations;

import Everdell.BasicLocation.TwoCardsAndPoint;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwoCardsAndPoint {
    private TwoCardsAndPoint twoCardsAndPoint;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoCardsAndPoint = new TwoCardsAndPoint();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoCardsAndPoint (){
        assertEquals(0, player.getPointTokens());
        assertEquals(0, player.getHandSize());

        twoCardsAndPoint.visit(player.nextAvailableWorker(), game);
        assertEquals(1, player.getPointTokens());
        assertEquals(2, player.getHandSize());

        twoCardsAndPoint.visit(player.nextAvailableWorker(), game);
        assertEquals(2, player.getPointTokens());
        assertEquals(4, player.getHandSize());
    }
}
