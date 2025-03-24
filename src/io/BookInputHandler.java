package io;

import data.Book;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import CustomList.MyArrayList;
import search.BinarySearch;
import search.Key;
import search.KeyInput;
import sort.ShellSort;

import java.io.IOException;
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
                try{
                    dataRandomInputArray(scanner);
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
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

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество книг не может быть отрицательным: " + length);
        }

        // Создание массива книг
        MyArrayList<Book> books = ManualDataInput.manualBookDataInput(length);

        //Сортировка списка книг
        MyArrayList<Book> sortBooks = books.copy();
        ShellSort<Book> shellBookSort = new ShellSort<>();
        shellBookSort.sort(sortBooks);

        // Вывод созданных книг
        System.out.println("Cписок книг:");
        books.toPrint();

        // Вывод отсортированного списка книг
        System.out.println("Отсортированный список книг:");
        sortBooks.toPrint();

        //Запись отсортированного списка в файл
        try {
            sortBooks.toFileWrite();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Book> binaryCarSearch = new BinarySearch<>();
            Key<Book> searchKey = KeyInput.createBookKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortBooks, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
                //Запись найденного элемента в файл
                try {
                    sortBooks.toFileWriteSearch(index);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/book/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println("Путь до считываемого файла "+filePath);

        //Список книг
        MyArrayList<Book> books = FileReaderDataInput.readBookFromFile(filePath);

        //Сортировка списка книг
        MyArrayList<Book> sortBooks = books.copy();
        ShellSort<Book> shellBookSort = new ShellSort<>();
        shellBookSort.sort(sortBooks);

        // Вывод созданных книг
        System.out.println("Cписок книг:");
        books.toPrint();

        // Вывод отсортированного списка книг
        System.out.println("Отсортированный список книг:");
        sortBooks.toPrint();

        //Запись отсортированного списка в файл
        sortBooks.toFileWrite();

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Book> binaryCarSearch = new BinarySearch<>();
            Key<Book> searchKey = KeyInput.createBookKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortBooks, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
                //Запись найденного элемента в файл
                sortBooks.toFileWriteSearch(index);
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }

    @Override
    public void dataRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество книг: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество книг не может быть отрицательным: " + length);
        }

        //Список книг
        MyArrayList<Book> books = RandomDataInput.createBookRandomInputArray(length);

        //Сортировка списка книг
        MyArrayList<Book> sortBooks = books.copy();
        ShellSort<Book> shellBookSort = new ShellSort<>();
        shellBookSort.sort(sortBooks);

        // Вывод созданных книг
        System.out.println("Cписок книг:");
        books.toPrint();

        // Вывод отсортированного списка книг
        System.out.println("Отсортированный список книг:");
        sortBooks.toPrint();

        //Запись отсортированного списка в файл
        sortBooks.toFileWrite();

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Book> binaryCarSearch = new BinarySearch<>();
            Key<Book> searchKey = KeyInput.createBookKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortBooks, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
                //Запись найденного элемента в файл
                sortBooks.toFileWriteSearch(index);
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }
}