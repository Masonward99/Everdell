package Everdell.Gui;

import Everdell.Cards.Card;
import Everdell.Cards.Critter;

import javax.swing.*;
import java.awt.*;

public class GuiCard extends javax.swing.JPanel {
    public GuiCard(Card card) {
        setLayout(new GridLayout(5,1));
        add(new JLabel("Name: " +card.getName()));
        add(new JLabel(card.isUnique()? "Unique" : "Common" + " " + (card instanceof Critter? "Critter" : "Construction" )));
        add(new JLabel("Points: " +card.getPoints()));
        add(new JLabel("Ability " + card.getAbility()));
        add(new JLabel("Costs: " + card.getCosts()));
    }
}
