import Everdell.BasicLocation.BasicLocation;
import Everdell.BasicLocation.Location;
import Everdell.BasicLocation.OneBerry;
import Everdell.ForestLocations.ForestLocation;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TestGame {
    private Game game;
    private Player player;
    private BasicLocation location;

    @Before
    public void setUp() {
        game = new Game(0);
        player = new Player("Steve");
        location = new OneBerry();
    }

    @Test
    public void testVisitLocation(){
        assert(player.nextAvailableWorker() == player.getWorkers().getFirst());
        game.visitLocation(player, location);
        assertEquals(1,(int) player.getResources().get(Resource.BERRIES));
        assert(player.nextAvailableWorker() == player.getWorkers().get(1));
        assert(player.getWorkers().getFirst() == location.getWorkers().getFirst());
    }

    @Test
    public void testGainAny(){
        //simulate user input
        String input = "0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game = new Game(0);
        assertEquals(0, (int) player.getResources().get(Resource.TWIGS));
        assertEquals(0, (int) player.getResources().get(Resource.STONES));

        game.gainAnyResource(2, player);
        assertEquals(1,(int) player.getResources().get(Resource.TWIGS));
        assertEquals(1,(int) player.getResources().get(Resource.RESIN));
    }

    @Test
    public void testGainAnyWithOutOfRangeValues(){
        String input = "5\n3\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game = new Game(0);
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES));
        game.gainAnyResource(1, player);
        assertEquals(1,(int) player.getResources().get(Resource.BERRIES));
    }
    @Test
    public void testSetUpForest(){
        ForestLocation[] forestLocations = game.getForestLocations();
        assert(forestLocations.length == 4);
        System.out.println(forestLocations[0]);
        assert(forestLocations[0] != forestLocations[1]);
        assert(forestLocations[0] != forestLocations[2]);
        assert(forestLocations[0] != forestLocations[3]);
        assert(forestLocations[3] != null);

        game = new Game(2);
        forestLocations = game.getForestLocations();
        assert(forestLocations.length == 4);
        assert(forestLocations[3] == null);
    }
}
