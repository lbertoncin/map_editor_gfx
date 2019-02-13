package org.academiadecodigo.asciimos.mapeditorgfx;

import java.io.*;

public class IO {

    public static void save(String data, String destination) {
        try {
            FileWriter writer = new FileWriter(destination);
            BufferedWriter bWriter = new BufferedWriter(writer);

            bWriter.write(data);
            bWriter.flush();
            bWriter.close();

        } catch (Exception e) {
            System.out.println("Error saving the file!");
        }
    }

    public static String load(String destination) {
        try {
            FileReader reader = new FileReader(destination);
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";
            String result = "";

            while ((line = bReader.readLine()) != null) {
                result += line + "\n";
            }

            bReader.close();
            return result;

        } catch (Exception e) {
            System.out.println("Error loading the file!");
        }
        return null;
    }
}
