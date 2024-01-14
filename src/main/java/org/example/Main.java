package org.example;
import org.example.controllers.GLoginRegisterController;
import org.example.export.JPGExporter;

public class Main {
    public static void main(String[] args) {
        GLoginRegisterController gLoginRegisterController = new GLoginRegisterController();
        gLoginRegisterController.run();
//        JPGExporter jpgExporter = new JPGExporter();
//        jpgExporter.save(1, "test");
    }
}