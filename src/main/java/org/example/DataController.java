package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataController {
    String nameFile = "src/main/java/org/example/users.txt";
    public void LoadDataUser() {
        try {
            IConnection connection = Database.getConnection();
            File file = new File(nameFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 4) {
                    String name = values[0];
                    String username= values[1];
                    String email= values[1];
                    String password= values[1];
                    connection.addUser(name, username, email, password);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku: " + nameFile);
        }
    }
}
