package TestCards.TestProsperity;

import Everdell.Cards.Production.BargeToad;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.Theater;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTheater {
    private Theater theater;
    private Player player;
    @Before
    public void setUp() {
        theater = new Theater();
        player = new Player("Steve");
    }
    @Test
    public void testBonus() {
        assertEquals(0, theater.bonusPoints(player));
        player.addCardToBoard(new Architect());
        player.addCardToBoard(new Architect());
        assertEquals(2, theater.bonusPoints(player));
        player.addCardToBoard(new BargeToad());
        assertEquals(2, theater.bonusPoints(player));
    }
}
