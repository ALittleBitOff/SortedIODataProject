package io;

import data.Book;
import io.manualInput.BookDataInput;
import io.textInput.FileReaderDataInput;
import CustomList.MyArrayList;
import java.io.IOException;
import java.util.List;
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
                try{
                    dataTextInputArray(scanner);
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("Ввод случайных данных.");
                // Логика для ввода случайных данных
                break;
            case 3:
                System.out.println("Ввод данных вручную.");
                handleManualInputArray(scanner);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    @Override
    public void handleManualInputArray(Scanner scanner) {
        System.out.print("Введите количество книг: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создание массива книг
        MyArrayList<Book> books = BookDataInput.createBookArrayFromConsole(length);

        // Вывод созданного списка книг
        System.out.println("Список книг: ");
        for (int i = 0; i < length; i++) {
            System.out.println(books.get(i).toString());
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/book/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println(filePath);
        List<Book> books = FileReaderDataInput.readBookFromFile(filePath);

        // Вывод созданных автомобилей
        System.out.println("Список автомобилей:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}