package io.textInput;

import data.Book;
import data.Car;
import data.Korneplod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderDataInput {

    public static List<Car> readCarsFromFile(String filePath) throws IOException {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
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

    public static List<Book> readBookFromFile(String filePath) throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
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

    public static List<Korneplod> readKorneplodFromFile(String filePath) throws IOException {
        List<Korneplod> korneplods = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    try {
                        String type = parts[0].trim();
                        double weight = Double.parseDouble(parts[1].trim());
                        String color = parts[2].trim();
                        korneplods.add(new Korneplod.Builder()
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
        return korneplods;
    }
}