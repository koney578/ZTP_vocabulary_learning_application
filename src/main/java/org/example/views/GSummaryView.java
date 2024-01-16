package org.example.views;

import org.example.controllers.GLearningTestController;
import org.example.controllers.GSummaryController;
import org.example.export.BMPExporter;
import org.example.export.JPGExporter;
import org.example.export.PNGExporter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GSummaryView {
    private GSummaryController gSummaryController;
    private JFrame jframe;
    public GSummaryView(GSummaryController gSummaryController, JFrame jframe) {
        this.gSummaryController = gSummaryController;
        this.jframe = jframe;
    }

    public void show() {
        jframe.getContentPane().removeAll();
        jframe.getContentPane().revalidate();
        jframe.getContentPane().repaint();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(12,1));
        jframe.getContentPane().add(mainPanel);

        JLabel label1 = new JLabel("Twój wynik to: "+ gSummaryController.getResult()+"/5");
        label1.setFont(new Font("Arial", Font.ITALIC, 24));
        label1.setForeground(Color.BLUE);
        mainPanel.add(label1);

        JLabel label3 = new JLabel("");
        label3.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label3);

        JLabel label2 = new JLabel("Czy chcesz zapisać swój wynik w formie zdjęcia? (jeśli tak wybierz rozszerzenie)");
        label2.setFont(new Font("Arial", Font.ITALIC, 18));
        mainPanel.add(label2);

        JButton firstButton = new JButton("PNG");
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PNGExporter pngExporter = new PNGExporter();
                pngExporter.save(Integer.parseInt(gSummaryController.getResult()), "test1");
            }
        });

        firstButton.setBackground(Color.PINK);
        mainPanel.add(firstButton);

        JButton thirdButton = new JButton("JPG");
        thirdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPGExporter jpgExporter = new JPGExporter();
                jpgExporter.save(Integer.parseInt(gSummaryController.getResult()), "test2");
            }
        });

        thirdButton.setBackground(Color.PINK);
        mainPanel.add(thirdButton);

        JButton fourthButton = new JButton("BMP");
        fourthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BMPExporter bmpExporter = new BMPExporter();
                bmpExporter.save(Integer.parseInt(gSummaryController.getResult()), "test3");
            }
        });

        fourthButton.setBackground(Color.PINK);
        mainPanel.add(fourthButton);

        JLabel label4 = new JLabel("");
        label4.setFont(new Font("Arial", Font.ITALIC, 24));
        mainPanel.add(label4);

        JButton secondButton = new JButton("Powrót");
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gSummaryController.getNewMenuView();
            }
        });

        secondButton.setBackground(Color.PINK);
        mainPanel.add(secondButton);

        jframe.setVisible(true);
    }
}
