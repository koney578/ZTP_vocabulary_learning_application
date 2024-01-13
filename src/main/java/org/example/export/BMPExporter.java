package org.example.export;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BMPExporter extends Exporter {

    @Override
    public void save(Integer result, String filename) {
        // Tworzenie obrazu
        int width = 600;
        int height = 300;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // Stylizacja
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));

        // Wypisywanie wyniku testu
        String resultText = "Wynik testu: " + result;
        g.drawString(resultText, 30, 40);

        // Zapis obrazu do pliku BMP
        try {
            File output = new File(filename + ".bmp");
            ImageIO.write(image, "bmp", output);
            System.out.println("Plik BMP zapisany pomyślnie: " + output.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
