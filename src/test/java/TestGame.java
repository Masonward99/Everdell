import Everdell.Locations.BasicLocation.BasicLocation;
import Everdell.Locations.BasicLocation.OneBerry;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.ResinRefinery;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.Prosperity.Palace;
import Everdell.Cards.Prosperity.Theater;
import Everdell.Locations.ForestLocations.ForestLocation;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

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

    @Test
    public void testDiscardCardsWith1Discard(){
        String input = "5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game = new Game(0);

        player.addCard(new Farm());
        player.addCard(new Architect());
        player.addCard(new Castle());
        player.addCard(new Palace());
        player.addCard(new ResinRefinery());
        Theater theater = new Theater();
        player.addCard(theater);
        assertTrue(player.getHand().contains(theater));
        game.discardCards(1, player);
        assertFalse(player.getHand().contains(theater));
        assertEquals(5, player.getHandSize() );
        assertEquals(1, game.getDiscard().size());

    }
    @Test
    public void testDiscardCardsWith3Discard(){
        String input = "5\n0\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game = new Game(0);
        Farm farm = new Farm();
        player.addCard(farm);
        player.addCard(new Architect());
        Castle castle = new Castle();
        player.addCard(castle);
        player.addCard(new Palace());
        player.addCard(new ResinRefinery());
        Theater theater = new Theater();
        player.addCard(theater);
        assertTrue(player.getHand().contains(theater));
        assertTrue(player.getHand().contains(castle));
        assertTrue(player.getHand().contains(farm));
        assertEquals(6, player.getHandSize());
        game.discardCards(3, player);
        assertFalse(player.getHand().contains(theater));
        assertFalse(player.getHand().contains(castle));
        assertFalse(player.getHand().contains(farm));
        assertEquals(3, player.getHandSize());
        assertEquals(3, game.getDiscard().size());
        assertEquals(castle, game.getDiscard().getLast());
    }

    @Test
    public void testRefillMeadow(){
        assertEquals(8, game.getMeadow().getCards().size());
        assertFalse(game.getMeadow().getCards().contains(null));
        game.getMeadow().discard(game.getMeadow().getCards().get(0));
        game.getMeadow().discard(game.getMeadow().getCards().get(1));
        assertEquals(6, game.getMeadow().getCards().size() );
        game.refillMeadow();
        assertEquals(8, game.getMeadow().getCards().size() );
    }
}
