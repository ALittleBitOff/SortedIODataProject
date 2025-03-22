package io.manualInput;

import CustomList.MyArrayList;
import data.Book;
import data.Car;
import data.Korneplod;

import java.util.Scanner;

public class ManualDataInput {

    public static MyArrayList<Car> manualCarDataInput(int length){
        MyArrayList<Car> cars = new MyArrayList<>();

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < length; i++) {
            System.out.println("Автомобиль номер: "+i);
            System.out.println("Введите мощность (int): ");
            int power = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            System.out.println("Введите модель (String): ");
            String model = scanner.nextLine();

            System.out.println("Введите год изготовления (int): ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            cars.add(new Car.Builder()
                    .sethorsePower(power)
                    .setmodel(model)
                    .setreleaseYear(year)
                    .build());
        }
        return cars;
    }

    public static MyArrayList<Book> manualBookDataInput(int length){
        MyArrayList<Book> books = new MyArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("Книга номер :"+i);
            System.out.println("Введите автора книги (String): ");
            String author = scanner.nextLine();

            System.out.println("Введите название книги (String): ");
            String title = scanner.nextLine();

            System.out.println("Введите количество страниц (int): ");
            int pages = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера
            books.add(new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPageCount(pages)
                    .build());
        }
        return books;
    }

    public static MyArrayList<Korneplod> manualKorneplodDataInput(int length){
        MyArrayList<Korneplod> korneplods = new MyArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("Корнеплод номер: "+i);
            System.out.println("Введите тип (String): ");
            String type = scanner.nextLine();

            System.out.println("Введите массу (double): ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Очистка буфера

            System.out.println("Введите цвет (String): ");
            String color = scanner.nextLine();
            korneplods.add(new Korneplod.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build());
        }
        return korneplods;
    }
}

