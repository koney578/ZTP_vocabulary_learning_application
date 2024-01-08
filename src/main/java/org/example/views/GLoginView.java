package org.example.views;

import org.example.controllers.GLoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GLoginView {
    private JFrame jframe;
    private GLoginController gLoginController;
    private Timer timer;
    private Timer timer1;
    public GLoginView(GLoginController gLoginController, JFrame jframe) {
        this.gLoginController = gLoginController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Uzupełnij poniższe pola: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("Nazwa użytkownika:");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JTextField textField = new JTextField("");
        mainPanel.add(textField);

        JLabel label4 = new JLabel("Hasło:");
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JTextField textField2 = new JTextField("");
        mainPanel.add(textField2);

        JLabel label5 = new JLabel("");
        label5.setFont(new Font("Arial", Font.ITALIC, 24));
        label5.setForeground(Color.RED);
        mainPanel.add(label5);


        JButton firstButton = new JButton("Zaloguj");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label5.setText(gLoginController.checkDataLogin(textField.getText(), textField2.getText()));
                timer = new Timer(250, new ActionListener() {
                    private boolean visible = true;
                    private int elapsedTime = 0;
                    private final int duration = 2000;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (elapsedTime < duration) {
                            label5.setVisible(visible);
                            visible = !visible;
                            elapsedTime += 250;
                        } else {
                            timer.stop();
                        }
                    }
                });

                timer.setRepeats(true);
                timer.start();
            }});
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gLoginController.getNewLoginRegisterView();
            }
        });

        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
