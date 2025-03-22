package io.textInput;

import CustomList.MyArrayList;
import data.Book;
import data.Car;
import data.Korneplod;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDataInput {

    public static MyArrayList<Car> readCarsFromFile(String filePath) throws IOException {
        MyArrayList<Car> cars = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Пропускаем пустые строки
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        int power = Integer.parseInt(parts[0].trim());
                        String model = parts[1].trim();
                        int year = Integer.parseInt(parts[2].trim());
                        cars.add(new Car.Builder()
                                .sethorsePower(power)
                                .setmodel(model)
                                .setreleaseYear(year)
                                .build());
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный формат данных в строке: " + line);
                    }
                } else {
                    System.err.println("Неверный формат линии: " + line);
                }
            }
        }
        return cars;
    }

    public static MyArrayList<Book> readBookFromFile(String filePath) throws IOException {
        MyArrayList<Book> books = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Пропускаем пустые строки
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String author = parts[0].trim();
                        String title = parts[1].trim();
                        int pageCount = Integer.parseInt(parts[2].trim());
                        books.add(new Book.Builder()
                                .setAuthor(author)
                                .setTitle(title)
                                .setPageCount(pageCount)
                                .build());
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный формат данных в строке: " + line);
                    }
                } else {
                    System.err.println("Неверный формат линии: " + line);
                }
            }
        }
        return books;
    }

    public static MyArrayList<Korneplod> readKorneplodFromFile(String filePath) throws IOException {
        MyArrayList<Korneplod> Korneplods = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Пропускаем пустые строки
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String type = parts[0].trim();
                        double weight = Double.parseDouble(parts[1].trim());
                        String color = parts[2].trim();
                        Korneplods.add(new Korneplod.Builder()
                                .setType(type)
                                .setWeight(weight)
                                .setColor(color)
                                .build());
                    } catch (NumberFormatException e) {
                        System.err.println("Неверный формат данных в строке: " + line);
                    }
                } else {
                    System.err.println("Неверный формат линии: " + line);
                }
            }
        }
        return Korneplods;
    }
}