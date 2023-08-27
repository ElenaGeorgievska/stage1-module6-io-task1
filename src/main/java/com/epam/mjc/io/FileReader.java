package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    //Steps/Tips for solving
    //1. read file into a string
    //2. split a string into parts by line break character
    //3. split each string from previous step by symbol ':'
    //4. put the result into a map

    String line = null;
    Map<String, String> result = new HashMap<>();
    String[] array = {};

    public Profile getDataFromFile(File file) {       //String file = "src/test/resources/Profile.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((line = reader.readLine()) != null) {
                array = line.split(":");
                result.put(array[0], array[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(result.get("Name").trim(), Integer.parseInt(result.get("Age").trim()), result.get("Email").trim(), Long.parseLong(result.get("Phone").trim()));
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        System.out.println(fileReader.getDataFromFile(new File("src/main/resources/Profile.txt")));
    }

    //https://mkyong.com/java/how-to-read-file-in-java-fileinputstream/
}

