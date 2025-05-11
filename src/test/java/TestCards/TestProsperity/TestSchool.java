package TestCards.TestProsperity;

import Everdell.Cards.Production.ChipSweep;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.HusbandAndWife;
import Everdell.Cards.Prosperity.Architect;
import Everdell.Cards.Prosperity.School;
import Everdell.Cards.TanTraveller.Wanderer;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSchool {
    private School school;
    private Game game;
    private Player player;

    @Before
    public void setUp() {
        school = new School();
        player = new Player("Steve");
        game = new Game(0);
    }

    @Test
    public void testSchool() {
        HusbandAndWife husbandAndWife = new HusbandAndWife();
        Wanderer wanderer = new Wanderer();
        player.addCardToBoard(husbandAndWife);
        player.addNonBoardCard(wanderer);
        //does not mutate board
        assertFalse(player.isCardOnBoard(wanderer));
        school.bonusPoints(player);
        assertFalse(player.isCardOnBoard(wanderer));
        assertTrue(player.isCardOnBoard(husbandAndWife));

        assertEquals(3, school.bonusPoints(player));
        player.addCardToBoard(new Farm());
        assertEquals(3, school.bonusPoints(player));
        player.addCardToBoard(new Architect());
        assertEquals(3, school.bonusPoints(player));
        player.addCardToBoard(new ChipSweep());
        assertEquals(4, school.bonusPoints(player));
    }
}
