package Everdell.Gui;

import Everdell.Cards.Production.Farm;
import Everdell.Game;
import Everdell.Locations.BasicLocation.BasicLocation;
import Everdell.Locations.Location;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Gui{
    private JFrame frame;
    public Gui(Game game) {
        makeFrame(game);
    }

    private void makeFrame(Game game) {
        frame = new JFrame("Everdell");
        System.out.println(game);
        Container contentPane = frame.getContentPane();
        frame.add(new JLabel("Everdell"));
        frame.add(addBasicLocations(game));
        frame.add(new GuiCard(new Farm()));
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel addBasicLocations(Game game) {
        JPanel locations = new JPanel();
        locations.setLayout(new GridLayout(1, 8, 20, 10));
        ArrayList<BasicLocation> locationsList = new ArrayList<>(Arrays.asList(game.getBasicLocations()));
        for (BasicLocation location : locationsList) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 1));
            panel.add(new JLabel(location.getName(), SwingConstants.CENTER));
            panel.add(new SharedLocation(location, game));
            locations.add(panel);
        }
        return locations;
    }
    public JFrame getFrame() {
        return frame;
    }
}
