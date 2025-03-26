package io.textInput;

import CustomList.MyArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileReaderDataInput<T> {

    protected abstract T parseLine(String[] parts) throws NumberFormatException;

    public MyArrayList<T> readFromFile(String filePath) throws IOException {
        MyArrayList<T> items = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                try {
                    T item = parseLine(parts);
                    items.add(item);
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка обработки строки: " + line + ". Причина: " + e.getMessage());
                }
            }
        }
        return items;
    }
}
