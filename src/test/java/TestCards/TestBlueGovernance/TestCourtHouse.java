package TestCards.TestBlueGovernance;

import Everdell.Cards.BlueGovernance.Courthouse;
import Everdell.Cards.Card;
import Everdell.Game;
import Everdell.Player;
import Everdell.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TestCourtHouse {
    private Courthouse courthouse;
    private Player player;
    private Game game;
    @Before
    public void setUp() {
        courthouse = new Courthouse();
        player = new Player("Steve");
        game = new Game(0);
    }
    @Test
    public void testCourtHouseAbility() {
        String inputStr = "0\n2\n1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);
        //needs to be created after inputString
        game = new Game(0);

        courthouse.ability(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.TWIGS));
        courthouse.ability(player, game);
        assertEquals(1, (int) player.getResources().get(Resource.STONES));
    }
}
