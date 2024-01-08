package org.example.views;

import org.example.controllers.GRegisterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GRegisterView {
    private JFrame jframe;
    private GRegisterController gRegisterController;
    public GRegisterView(GRegisterController gRegisterController, JFrame jframe) {
        this.gRegisterController= gRegisterController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(15,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Aby się zarejestrować uzupełnij poniższe pola: ");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label2);

        JLabel label3 = new JLabel("Imię:");
        label3.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label3);

        JTextField textField = new JTextField("");
        mainPanel.add(textField);

        JLabel label4 = new JLabel("Nazwa użytkownika:");
        label4.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label4);

        JTextField textField2 = new JTextField("");
        mainPanel.add(textField2);

        JLabel label5 = new JLabel("Adres email:");
        label5.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label5);

        JTextField textField3 = new JTextField("");
        mainPanel.add(textField3);

        JLabel label6 = new JLabel("Hasło:");
        label6.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label6);

        JTextField textField4 = new JTextField("");
        mainPanel.add(textField4);

        JLabel label7 = new JLabel("Powtórz hasło: ");
        label7.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label7);

        JTextField textField5 = new JTextField("");
        mainPanel.add(textField5);

        JLabel label8 = new JLabel("");
        label8.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label8);

        JButton firstButton = new JButton("Zarejestruj");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = gRegisterController.checkDataRegister(textField.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText());
                if(text.equals("Zarejestrowano pomyślnie, za 3 sekundy nastąpi przekierowanie do ekranu logowania!")){
                    label8.setForeground(Color.GREEN);
                    label8.setText(text);
                    Timer timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            gRegisterController.getNewLoginView();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                else{
                    label8.setForeground(Color.RED);
                }
                label8.setText(text);
            }
        });

        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gRegisterController.getNewLoginRegisterView();
            }
        });

        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
