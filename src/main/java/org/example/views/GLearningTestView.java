package org.example.views;

import org.example.controllers.GLearningTestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GLearningTestView {
    private GLearningTestController gLearningTestController;
    private JFrame jframe;

    public GLearningTestView(GLearningTestController gLearningTestController, JFrame jframe) {
        this.gLearningTestController = gLearningTestController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);


        JLabel label1 = new JLabel(gLearningTestController.getWords());
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label1);

        JButton firstButton = new JButton("Powrót!");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gLearningTestController.getNewMenuView();
            }
        });
        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);
        jframe.setVisible(true);
    }
}
