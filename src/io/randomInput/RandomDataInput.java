package io.randomInput;

import CustomList.MyArrayList;
import data.Car;
import data.Book;
import data.Korneplod;
import java.util.Random;


public class RandomDataInput {

    public static MyArrayList<Car> createCarRandomInputArray(int length){
        MyArrayList<Car> cars = new MyArrayList<>();

        //Список рандомных названий автомобилей
        String[] carModels = {"Toyota Camry", "Honda Accord", "Ford Mustang", "BMW X5", "Audi A4", "Tesla Model S"};

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int power = 50 + random.nextInt(451);
            String model = carModels[random.nextInt(carModels.length)];
            int year = 2000 + random.nextInt(24); // Год от 2000 до 2023;
            cars.add(new Car.Builder()
                    .sethorsePower(power)
                    .setmodel(model)
                    .setreleaseYear(year)
                    .build());
        }
        return cars;
    }

    public static MyArrayList<Book> createBookRandomInputArray(int length){
        MyArrayList<Book> books = new MyArrayList<>();

        //Список случайных названий автомобилей
        String[] authors = {"George Orwell", "J.K. Rowling", "J.R.R. Tolkien", "Leo Tolstoy"};
        String[] titles = {"1984", "Harry Potter", "The Lord of the Rings", "War and Peace"};

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            String author = authors[random.nextInt(authors.length)];
            String title = titles[random.nextInt(titles.length)];
            int pageCount = random.nextInt(2000);
            books.add(new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPageCount(pageCount)
                    .build());
        }
        return books;
    }

    public static MyArrayList<Korneplod> createKornepodRandomInputArray(int length) {
        MyArrayList<Korneplod> kornepods = new MyArrayList<>();

        //Список случайных данных
        String[] types = {"Carrot", "Potato", "Beetroot", "Radish"};
        String[] colors = {"Orange", "Brown", "Purple", "Red"};

        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            String type = types[random.nextInt(types.length)];
            double weight = (double) Math.round(0.1 + (200) * random.nextDouble()) /100;
            String color = colors[random.nextInt(colors.length)];
            kornepods.add(new Korneplod.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build());
        }
        return kornepods;
    }
}
