package org.example.views;

import org.example.Word;
import org.example.controllers.GLearningTestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        JLabel label1 = new JLabel(gLearningTestController.getMessage());
        label1.setFont(new Font("Arial", Font.ITALIC, 14));
        label1.setForeground(Color.GRAY);
        mainPanel.add(label1);

        List<Word> words = gLearningTestController.getWords();

        if (gLearningTestController.getMode()){
            JLabel label2 = new JLabel("Przetłumacz słowo:");
            label2.setFont(new Font("Arial", Font.ITALIC, 24));
            mainPanel.add(label2);

            JLabel label3= new JLabel(gLearningTestController.getWord().getPolishWord());
            label3.setFont(new Font("Arial", Font.ITALIC, 24));
            label3.setForeground(new Color(50, 121, 7));
            mainPanel.add(label3);
        }
        else{
            JLabel label2 = new JLabel("Translate word:");
            label2.setFont(new Font("Arial", Font.ITALIC, 24));
            mainPanel.add(label2);
            JLabel label3= new JLabel(gLearningTestController.getWord().getEnglishWord());
            label3.setFont(new Font("Arial", Font.ITALIC, 24));
            label3.setForeground(new Color(50, 121, 7));
            mainPanel.add(label3);
        }

        for (int i = 0; i < words.size(); i++){
            Word word = words.get(i);
            if(gLearningTestController.getMode()) {
                JButton newButton = new JButton(String.valueOf(i+1)+") "+ word.getEnglishWord());
                newButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String information = gLearningTestController.checkAnswer(word);
                        if (information == "go"){
                            newButton.setBackground(Color.GREEN);
                            Timer delayTimer = new Timer(1000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int question = gLearningTestController.checkQuestion();
                                    if (question >= 5){
                                        gLearningTestController.refreshWordFamiliarized();
                                        gLearningTestController.getNewMenuView();
                                    }else {
                                        gLearningTestController.removeWordFamilirized();
                                        gLearningTestController.run();
                                    }
                                }
                            });

                            delayTimer.setRepeats(false);
                            delayTimer.start();

                        }
                        else if(information == "stop"){
                            newButton.setBackground(Color.RED);
                        } else if (information == "next") {
                            gLearningTestController.removeWordFamilirized();
                            int question = gLearningTestController.checkQuestion();
                            if (question >= 5){
                                gLearningTestController.refreshWordFamiliarized();
                                gLearningTestController.getNewMenuView();
                            }else {
                                gLearningTestController.removeWordFamilirized();
                                gLearningTestController.run();
                            }
                        }

                    }
                });
                newButton.setBackground(Color.PINK);
                mainPanel.add(newButton);
            }else{
                JButton newButton = new JButton(String.valueOf(i+1)+") "+ word.getPolishWord());
                newButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String information = gLearningTestController.checkAnswer(word);
                        if (information == "go"){
                            newButton.setBackground(Color.GREEN);
                            Timer delayTimer = new Timer(2000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int question = gLearningTestController.checkQuestion();
                                    if (question >= 5){
                                        gLearningTestController.refreshWordFamiliarized();
                                        gLearningTestController.getNewMenuView();
                                    }else {
                                        gLearningTestController.removeWordFamilirized();
                                        gLearningTestController.run();
                                    }
                                }
                            });

                            delayTimer.setRepeats(false); // Ustawienie, aby timer nie powtarzał się
                            delayTimer.start();
                        }
                        else if(information == "stop"){
                            newButton.setBackground(Color.RED);
                        }
                        else if (information == "next") {
                            gLearningTestController.removeWordFamilirized();
                            int question = gLearningTestController.checkQuestion();
                            if (question >= 5){
                                gLearningTestController.refreshWordFamiliarized();
                                gLearningTestController.getNewMenuView();
                            }else {
                                gLearningTestController.removeWordFamilirized();
                                gLearningTestController.run();
                            }
                        }

                    }
                });
                newButton.setBackground(Color.PINK);
                mainPanel.add(newButton);
            }

        }

        JLabel label2 = new JLabel("");
        label2.setFont(new Font("Arial", Font.ITALIC, 14));
        mainPanel.add(label2);


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
