package TestBasicLocations;

import Everdell.Locations.BasicLocation.OneBerry;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestOneBerry {
    private OneBerry oneBerry;
    private Player player;
    private Game game;
    @Before
    public void setUp() {
        oneBerry = new OneBerry();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testVisit(){
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        oneBerry.visit(player,game);
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES));

        oneBerry.visit(player,game);
        assertEquals(2, (int) player.getResources().get(Resource.BERRIES));
    }

}
