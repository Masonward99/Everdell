package TestCards.TestProduction;

import Everdell.Cards.Production.ChipSweep;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Production.ResinRefinery;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestChipSweep {
    private ChipSweep chipSweep;
    private Game game;
    private Player player;
    @Before
    public void setUp() {
        chipSweep = new ChipSweep();
        game = new Game(0);
        player = new Player("Steve");
    }
    @Test
    public void testChipSweep() {
        String input = "0\n0\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        game = new Game(0);


        player.addCardToBoard(chipSweep);
        Farm farm = new Farm();
        ResinRefinery resinRefinery = new ResinRefinery();
        player.addCardToBoard(farm);
        player.addCardToBoard(resinRefinery);
        assertEquals(0, (int) player.getResources().get(Resource.BERRIES ));
        chipSweep.action(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.BERRIES ));
        chipSweep.action(player, game);
        assertEquals(2, (int) player.getResources().get(Resource.BERRIES ));
        //does not mutate player board
        assertTrue(player.getBoard().contains(chipSweep));
        assertTrue(player.getBoard().contains(farm));
        assertTrue(player.getBoard().contains(resinRefinery));
    }
}
