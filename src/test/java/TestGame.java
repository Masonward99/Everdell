import Everdell.BasicLocation.BasicLocation;
import Everdell.BasicLocation.Location;
import Everdell.BasicLocation.OneBerry;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

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
}
