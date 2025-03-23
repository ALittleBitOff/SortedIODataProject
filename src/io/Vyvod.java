package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vyvod {
    public static <T extends Sortable> void sortAndSave(List<T> items, String filename) throws IOException {
        Collections.sort(items, Comparator.comparing(Sortable::getSortingKey));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            for (T item : items) {
                bw.write(item.toString());
                bw.newLine();
            }
        }
    }

    public static <T extends Sortable> List<T> loadFromFile(String filename, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {
        List<T> items = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
        }
        br.close();
        return items;
    }
}