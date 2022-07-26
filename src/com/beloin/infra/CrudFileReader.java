package com.beloin.infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CrudFileReader {
    public List<String> read(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        List<String> lines = new LinkedList<>();

        while (reader.hasNextLine()) {
            String currentLine = reader.nextLine();
            lines.add(currentLine);
        }

        reader.close();

        return lines;
    }
}
