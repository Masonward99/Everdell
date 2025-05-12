package TestForestLocations;

import Everdell.Cards.Destination.Chapel;
import Everdell.Cards.Production.Doctor;
import Everdell.Cards.Production.Farm;
import Everdell.Cards.Prosperity.Castle;
import Everdell.Cards.Prosperity.EverTree;
import Everdell.Locations.ForestLocations.DiscardCardsToDraw;
import Everdell.Game;
import Everdell.Player;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class TestDiscardToDraw {
    private DiscardCardsToDraw discardCardsToDraw;
    private Player player;
    private Game game;

    @Before
    public void setUp() {
        discardCardsToDraw = new DiscardCardsToDraw(2);
        game = new Game(0);
        player = new Player("Steve");
    }

    @Test
    public void testDiscardToDraw() {
        String inputString = "2\n1\n2\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(bais);
        game = new Game(0);

        player.addCard(new Farm());
        Doctor doctor = new Doctor();
        Chapel chapel = new Chapel();
        Castle castle = new Castle();
        EverTree everTree = new EverTree();
        player.addCard(doctor);
        player.addCard(chapel);
        player.addCard(castle);
        player.addCard(everTree);

        discardCardsToDraw.visit(player, game);
        assertFalse(player.getHand().contains(doctor));
        assertFalse(player.getHand().contains(castle));
        assertEquals(7, player.getHandSize());
    }

}
