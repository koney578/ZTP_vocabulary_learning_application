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

        JLabel label1 = new JLabel("Witaj "+gMenuController.getName()+"!");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(new Color(4, 122, 7));
        mainPanel.add(label1);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("W jakim trybie chcesz pracować?");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JButton firstButton = new JButton("Tryb nauki (nauka angielskiego - 5 słów)");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setEnglishMode(true);
                gMenuController.setStateLearning();
                gMenuController.getNewChooseStrategyView();
            }
        });

        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton fourthButton = new JButton("Tryb nauki (nauka polskiego - 5 słów)");
        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setEnglishMode(false);
                gMenuController.setStateLearning();
                gMenuController.getNewChooseStrategyView();
            }
        });

        fourthButton.setBackground(Color.PINK);
        mainPanel.add(fourthButton);

        JButton secondButton = new JButton("Tryb testu (znajomość angielskiego - 5 słów)");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setEnglishMode(true);
                gMenuController.setStateTest();
                gMenuController.getNewChooseStrategyView();
            }
        });

        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        JButton fifthButton = new JButton("Tryb testu (znajomość polskiego - 5 słów)");
        fifthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gMenuController.setEnglishMode(false);
                gMenuController.setStateTest();
                gMenuController.getNewChooseStrategyView();
            }
        });

        fifthButton.setBackground(Color.PINK);
        mainPanel.add(fifthButton);

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
