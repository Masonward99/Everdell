package TestCards.TestProduction;

import Everdell.Cards.Production.Storehouse;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestStoreHouse {
    private Storehouse storehouse;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        storehouse = new Storehouse();
        player = new Player("Steve");
        game = new Game(0);
    }

    @Test
    public void testAction() {
        assertEquals(0, (int)storehouse.getStoredResources().get(Resource.STONES));
        assertEquals(0, (int) storehouse.getStoredResources().get(Resource.TWIGS));
        assertEquals(0, (int) storehouse.getStoredResources().get(Resource.BERRIES));
        assertEquals(0, (int) storehouse.getStoredResources().get(Resource.RESIN));
        String input = "0\n1\n2\n3\n0\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        game = new Game(0);
        storehouse.action(player, game);
        assertEquals(3, (int)storehouse.getStoredResources().get(Resource.TWIGS));
        assertEquals(0, (int)storehouse.getStoredResources().get(Resource.RESIN));
        storehouse.action(player, game);
        assertEquals(2, (int)storehouse.getStoredResources().get(Resource.RESIN));
        assertEquals(0, (int)storehouse.getStoredResources().get(Resource.STONES));
        assertEquals(3, (int)storehouse.getStoredResources().get(Resource.TWIGS));
        storehouse.action(player, game);
        assertEquals(2, (int)storehouse.getStoredResources().get(Resource.RESIN));
        assertEquals(1, (int)storehouse.getStoredResources().get(Resource.STONES));
        assertEquals(0, (int)storehouse.getStoredResources().get(Resource.BERRIES));
        storehouse.action(player, game);
        assertEquals(1, (int)storehouse.getStoredResources().get(Resource.STONES));
        assertEquals(2, (int)storehouse.getStoredResources().get(Resource.BERRIES));
        storehouse.action(player, game);
        assertEquals(6, (int)storehouse.getStoredResources().get(Resource.TWIGS));
    }
    @Test
    public void testVisit() {
        String input = "0\n1\n2\n3\n0\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        game = new Game(0);
        storehouse.action(player, game);
        assertEquals(3, (int)storehouse.getStoredResources().get(Resource.TWIGS));
        storehouse.visit(player, game);
        assertEquals(0, (int)storehouse.getStoredResources().get(Resource.TWIGS));
        assertEquals(3, (int)player.getResources().get(Resource.TWIGS));
    }
}
