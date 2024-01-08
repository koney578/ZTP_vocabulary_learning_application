package org.example.views;

import org.example.controllers.GMenuController;

import javax.swing.*;
import java.awt.*;

public class GMenuView {

    private JFrame jframe;
    private GMenuController gMenuController;
    public GMenuView(GMenuController gMenuController, JFrame jframe) {
        this.gMenuController = gMenuController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Zalogowano pomyślnie!");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(Color.GREEN);
        mainPanel.add(label1);

        jframe.setVisible(true);
    }
}
