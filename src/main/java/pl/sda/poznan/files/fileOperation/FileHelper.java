package pl.sda.poznan.files.fileOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper {
    //old IO
    public static List<String> readAllLine(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;
            // w warunku petli musimy przypisac wartosc do zmiennej line
            // i sprawdzic czy to co odczytalismy jest rozna od null
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> splitLinesIntoWords(List<String> lines) {
        List<String> wordsResult = new ArrayList<>();
        // przejsc w petli przez liste lines
        // dla kazdego wykonuj
        // rozdziel po spacji, przecinku, sredniku
        // wpisz wynik do listy words
        for (String line : lines) {
            String[] words = line.split("\\s|\\, |\\. |\\.");
            wordsResult.addAll(Arrays.asList(words));
        }
        return wordsResult;
    }
}
