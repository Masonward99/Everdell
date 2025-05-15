package Everdell.Gui;

import Everdell.Game;
import Everdell.Locations.Location;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SharedLocation  extends JPanel  {
    private final Location location;
    private Game game;


    public SharedLocation(Location location, Game game) {
        this.location = location;
        this.addMouseListener(game);
        this.game = game;

    }
    @Override
    protected void paintComponent(Graphics g) {
        boolean visitable  = location.canVisit(game.getActivePlayer());
        g.setColor(visitable? Color.green: Color.red );
        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }
    public Location getEverdellLocation(){
        return location;
    }
}
