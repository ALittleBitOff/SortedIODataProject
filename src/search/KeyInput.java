package search;

import data.Book;
import data.Car;
import data.Korneplod;

import java.util.Scanner;

public class KeyInput {
    public static Key<Car> createCarKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите мощность (int): ");
        int power = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите модель (String): ");
        String model = scanner.nextLine();

        System.out.println("Введите год изготовления (int): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return new Key<>(new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build());
    }

    public static Key<Book> createBookKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите автора книги (String): ");
        String author = scanner.nextLine();

        System.out.print("Введите название книги (String): ");
        String title = scanner.nextLine();

        System.out.print("Введите количество страниц (int): ");
        int pages = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return new Key<>(new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pages)
                .build());
    }
    public static Key<Korneplod> createKornepodKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип (String): ");
        String type = scanner.nextLine();

        System.out.print("Введите массу (double): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите цвет (String): ");
        String color = scanner.nextLine();
        return new Key<>(new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build());
    }
}
