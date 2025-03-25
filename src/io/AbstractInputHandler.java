package io;

import CustomList.MyArrayList;
import search.BinarySearch;
import search.Key;
import sort.ShellSort;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class AbstractInputHandler<T extends Comparable<T>> {
    protected abstract MyArrayList<T> manualInput(int length);
    protected abstract MyArrayList<T> randomInput(int length);
    protected abstract MyArrayList<T> fileInput(String filePath) throws IOException;
    protected abstract Key<T> createKey();

    protected final String OUTPUT_INPUT_PATH = "src/test/resources/";

    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных:");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных вручную");

        int subChoice = scanner.nextInt();
        try {
            switch (subChoice) {
                case 1 -> dataTextInputArray(scanner);
                case 2 -> dataRandomInputArray(scanner);
                case 3 -> handleManualInputArray(scanner);
                default -> System.out.println("Неверный выбор.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleManualInputArray(Scanner scanner) {
        System.out.print("Введите количество элементов: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        MyArrayList<T> items = manualInput(length);
        processAndPrint(items);
    }

    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла: ");
        String filePath = OUTPUT_INPUT_PATH + scanner.next() + ".txt";
        scanner.nextLine();

        MyArrayList<T> items = fileInput(filePath);
        processAndPrint(items);
    }

    public void dataRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество элементов: ");
        int length = scanner.nextInt();
        scanner.nextLine();

        if (length < 0) {
            throw new IllegalArgumentException("Количество элементов не может быть отрицательным: " + length);
        }

        MyArrayList<T> items = randomInput(length);
        processAndPrint(items);
    }

    private void processAndPrint(MyArrayList<T> items) {
        MyArrayList<T> sortedItems = items.copy();
        ShellSort<T> shellSort = new ShellSort<>();
        shellSort.sort(sortedItems);

        System.out.println("======== Исходный список ========");
        items.toPrint();
        System.out.println("======== Отсортированный список ========");
        sortedItems.toPrint();

        performBinarySearch(sortedItems);

        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(OUTPUT_INPUT_PATH+"output.txt", false));
             PrintWriter writer = new PrintWriter(bufferedWriter)) {
            writer.println("======== Исходный список ========");
            writer.write(items.toString());
            writer.println("======== Отсортированный список ========");
            writer.write(sortedItems.toString());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл ", e);
        }
    }

    private void performBinarySearch(MyArrayList<T> sortedItems) {
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        Scanner scanner = new Scanner(System.in);
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<T> binarySearch = new BinarySearch<>();
            Key<T> searchKey = createKey();
            int index = binarySearch.binarySearch(sortedItems, searchKey.getValue());

            try (PrintWriter writer = new PrintWriter
                    (new FileWriter( OUTPUT_INPUT_PATH+"search_key.txt",false))) {
                if(index !=-1)
                {
                    String result = "Элемент " + searchKey.getValue() + " найден по индексу: " + index;
                    System.out.println();
                    writer.println(result);
                } else
                {
                    String result = "Элемент " + searchKey.getValue() + " не найден.";
                    System.out.println(result);
                    writer.println(result);
                }
            }catch (IOException e) {
                System.out.println("Ошибка в чтении файла: "+ e.getMessage());
            }

        }
    }
}
