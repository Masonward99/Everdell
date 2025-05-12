package TestBasicLocations;

import Everdell.Locations.BasicLocation.TwoTwigsAndCard;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwoTwigsAndCard {
    private TwoTwigsAndCard twoTwigsAndCard;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoTwigsAndCard = new TwoTwigsAndCard();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoTwigsAndCard() {
        twoTwigsAndCard.visit(player, game);
        assertEquals(1, player.getHandSize());
        assertEquals(2, (int) player.getResources().get(Resource.TWIGS));
        twoTwigsAndCard.visit(player, game);
        assertEquals(2, player.getHandSize());
        assertEquals(4, (int) player.getResources().get(Resource.TWIGS));
    }
}
