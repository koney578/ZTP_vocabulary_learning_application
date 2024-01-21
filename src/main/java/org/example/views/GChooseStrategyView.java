package org.example.views;

import org.example.controllers.GChooseStrategyController;
import org.example.controllers.GMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GChooseStrategyView {
    private JFrame jframe;
    private GChooseStrategyController gChooseStrategyController;

    public GChooseStrategyView(GChooseStrategyController gChooseStrategyController, JFrame jframe) {
        this.jframe = jframe;
        this.gChooseStrategyController = gChooseStrategyController;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Wybierz poziom trudności: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JButton firstButton = new JButton("Bardzo łatwy");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(1);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(false);
            }
        });

        firstButton.setBackground(new Color(2, 250, 2));
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Łatwy");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(2);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(false);
            }
        });

        secondButton.setBackground(new Color(3, 96, 3));
        mainPanel.add(secondButton);

        JButton thirdButton = new JButton("Średni");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(3);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(false);
            }
        });

        thirdButton.setBackground(new Color(250, 151, 2));
        mainPanel.add(thirdButton);

        JButton fourthButton = new JButton("Trudny");
        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(4);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(false);
            }
        });

        fourthButton.setBackground(new Color(238, 19, 48));
        mainPanel.add(fourthButton);

        JButton fifthButton = new JButton("Bardzo Trudny");
        fifthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(5);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(false);
            }
        });

        fifthButton.setBackground(new Color(164, 3, 3));
        mainPanel.add(fifthButton);

        JButton sixthButton = new JButton("Chcę aby poziom trudności zmieniał się automatycznie");
        sixthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.setStrategy(1);
                gChooseStrategyController.getNewLearningTestView();
                gChooseStrategyController.setMixed(true);
            }
        });

        sixthButton.setBackground(new Color(255, 71, 4));
        mainPanel.add(sixthButton);

        JLabel label3 = new JLabel("");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JButton seventhButton = new JButton("Powrót");
        seventhButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gChooseStrategyController.getNewMenuView();
            }
        });

        seventhButton.setBackground(Color.PINK);
        mainPanel.add(seventhButton);


        jframe.setVisible(true);
    }
}
