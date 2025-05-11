package TestForestLocations;

import Everdell.ForestLocations.BasicLocationAndCard;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestBasicLocationAndCard {
    private BasicLocationAndCard basicLocationAndCard;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        basicLocationAndCard = new BasicLocationAndCard(0);
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testBasicLocationAndCard() {
        String input = "0\n5\n3\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        game = new Game(0);

        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        basicLocationAndCard.visit(player.nextAvailableWorker(), game);
        assertEquals(1, player.getHandSize());
        assertEquals(3, (int) player.getResources().get(Resource.TWIGS));
        basicLocationAndCard.visit(player.nextAvailableWorker(), game);
        assertEquals(2, player.getHandSize());
        assertEquals(1, (int) player.getResources().get(Resource.STONES));
        assertEquals(3, (int) player.getResources().get(Resource.TWIGS));
        basicLocationAndCard.visit(player.nextAvailableWorker(), game);
        assertEquals(1, (int) player.getResources().get(Resource.RESIN));
        assertEquals(4, (int) player.getHandSize());
    }
}
