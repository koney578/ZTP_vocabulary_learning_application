package org.example.views;

import org.example.controllers.GController;
import org.example.controllers.GLoginRegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GLoginRegisterView {
    private JFrame jframe;
    private GLoginRegisterController gLoginRegisterController;
    public GLoginRegisterView(GLoginRegisterController gLoginRegisterController, JFrame jframe) {
        this.gLoginRegisterController = gLoginRegisterController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(9,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Witaj w aplikacji do nauki słówek!");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label6 = new JLabel("Aby móc korzystać z serwisu zaloguj się lub zarejestruj!");
        label6.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label6);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("Masz już konto?");
        label3.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label3);

        JButton firstButton = new JButton("Zaloguj się!");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gLoginRegisterController.getNewLoginView();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JLabel label5= new JLabel("Nie masz jeszcze konta?");
        label5.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label5);

        JButton secondButton = new JButton("Zarejestruj się!");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gLoginRegisterController.getNewRegisterView();
            }
        });
        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        JLabel label4 = new JLabel("Chcesz zakończyć pracę?");
        label4.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label4);

        JButton thirdButton = new JButton("Wyjście");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gLoginRegisterController.exitApp();
            }
        });
        thirdButton.setBackground(Color.PINK);
        mainPanel.add(thirdButton);

        jframe.setVisible(true);
    }
}
