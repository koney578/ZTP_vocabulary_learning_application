package org.example.views;

import org.example.controllers.GMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("W jakim trybie chcesz pracować?");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JButton firstButton = new JButton("Tryb nauki");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setStateLearning();
                gMenuController.getNewLearningTestView();
            }
        });

        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Tryb testu");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setStateTest();
                gMenuController.getNewLearningTestView();
            }
        });

        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        JButton thirdButton = new JButton("Wyloguj");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.getNewLoginRegisterView();
            }
        });

        thirdButton.setBackground(Color.PINK);
        mainPanel.add(thirdButton);

        jframe.setVisible(true);
    }
}
