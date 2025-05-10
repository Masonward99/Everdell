package TestEvent.TestBasicEvent;

import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Events.BasicEvents.CartographersExpedition;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCartographers {
    private  CartographersExpedition expedition;
    private  Game game;
    private  Player player;
    @Before
    public void setUp() {
        expedition = new CartographersExpedition();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testCanVisit(){
        assertFalse(expedition.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new Wanderer());
        player.addCardToBoard(new Wanderer());
        assertFalse(expedition.canVisit(player.nextAvailableWorker()));
        player.addCardToBoard(new Wanderer());
        assertTrue(expedition.canVisit(player.nextAvailableWorker()));
    }
    @Test
    public void testCanVisitWithCardsNotInBoard (){
        player.addCardToBoard(new Wanderer());
        player.addCardToBoard(new Wanderer());
        assertFalse(expedition.canVisit(player.nextAvailableWorker()));
        player.addNonBoardCard(new Wanderer());
        assertTrue(expedition.canVisit(player.nextAvailableWorker()));
    }
}
