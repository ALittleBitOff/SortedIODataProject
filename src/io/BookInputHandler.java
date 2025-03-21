package io;

import data.Book;
import java.util.Scanner;

public class BookInputHandler implements DataInputHandler {
    @Override
    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных для книг:");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных вручную");

        int subChoice = scanner.nextInt();
        switch (subChoice) {
            case 1:
                System.out.println("Ввод данных из файла.");
                // Логика для ввода из файла
                break;
            case 2:
                System.out.println("Ввод случайных данных.");
                // Логика для ввода случайных данных
                break;
            case 3:
                System.out.println("Ввод данных вручную.");
                handleManualInput(scanner);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private void handleManualInput(Scanner scanner) {
        System.out.print("Введите количество книг: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создание массива книг
        Book[] books = BookDataInput.createBookArrayFromConsole(length);

        // Вывод созданного списка книг
        System.out.println("Created cars:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}