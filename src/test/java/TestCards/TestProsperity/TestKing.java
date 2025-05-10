package TestCards.TestProsperity;

import Everdell.Cards.Prosperity.King;
import Everdell.Cards.Prosperity.Prosperity;
import Everdell.Events.BasicEvents.CartographersExpedition;
import Everdell.Events.BasicEvents.CityMonument;
import Everdell.Events.SpecialEvent.TheEverdellGames;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestKing {
    private King king;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        king = new King();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testKingBonus() {
        // with no events
        assertEquals(0, king.bonusPoints(player));
        // with 2 basic events
        player.addEvent(new CityMonument());
        player.addEvent(new CartographersExpedition());
        assertEquals(2, king.bonusPoints(player));
        //with 2 basic and 1 special
        player.addEvent(new TheEverdellGames());
        assertEquals(4, king.bonusPoints(player));
    }
}
