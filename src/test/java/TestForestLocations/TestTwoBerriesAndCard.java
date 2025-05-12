package TestForestLocations;

import Everdell.Locations.ForestLocations.TwoBerriesAndCard;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTwoBerriesAndCard {
    private TwoBerriesAndCard twoBerriesAndCard;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        twoBerriesAndCard = new TwoBerriesAndCard(2);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testTwoBerriesAndCard() {
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(0, player.getHandSize());

        twoBerriesAndCard.visit(player, game);
        assertEquals(2, (int) player.getResources().get(Resource.BERRIES));
        assertEquals(1, player.getHandSize());
    }
}
