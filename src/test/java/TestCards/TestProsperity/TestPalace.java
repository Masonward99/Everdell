package TestCards.TestProsperity;

import Everdell.Cards.Production.Fairgrounds;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.Prosperity.Palace;
import Everdell.Cards.Prosperity.Prosperity;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPalace {
    private Palace palace;
    private Player player;
    @Before
    public void setUp() {
        palace = new Palace();
        player = new Player("Steve");
    }
    @Test
    public void TestGetName() {
        assertEquals(0, palace.bonusPoints(player));
        player.addCardToBoard(palace);
        player.addCardToBoard(new Castle());
        assertEquals(2, palace.bonusPoints(player));
        //does not count unique critters
        player.addCardToBoard(new Architect());
        assertEquals(2, palace.bonusPoints(player));
        // does not count common constructions
        player.addCardToBoard(new Farm());
        assertEquals(2, palace.bonusPoints(player));

        player.addCardToBoard(new Fairgrounds());
        assertEquals(3, palace.bonusPoints(player));
    }
}
