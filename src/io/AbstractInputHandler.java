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

/**
 * Абстрактный класс для обработки ввода данных различных типов.
 * Класс предоставляет методы для ввода данных из различных источников:
 * <br> - вручную
 * <br> - случайным образом
 * <br> - из файла.
 * <br>
 * Классы-наследники должны реализовать абстрактные методы для каждого способа ввода данных.
 * <br>
 * Кроме того, класс выполняет сортировку данных с использованием алгоритма Шелла и
 * возможность выполнить бинарный поиск по отсортированным данным.
 *
 * @param <T> Тип данных, с которыми работает класс (должен быть Comparable).
 */
public abstract class AbstractInputHandler<T extends Comparable<T>> {

    /**
     * Метод для ввода данных вручную. Этот метод должен быть реализован в наследниках.
     *
     * @param length Количество элементов для ввода.
     * @return Список объектов типа {@link T}, введенных вручную.
     */
    protected abstract MyArrayList<T> manualInput(int length);

    /**
     * Метод для генерации случайных данных. Этот метод должен быть реализован в наследниках.
     *
     * @param length Количество случайных элементов для создания.
     * @return Список случайных объектов типа {@link T}.
     */
    protected abstract MyArrayList<T> randomInput(int length);

    /**
     * Метод для ввода данных из файла. Этот метод должен быть реализован в наследниках.
     *
     * @param filePath Путь к файлу, из которого будут считаны данные.
     * @return Список объектов типа {@link T}, считанных из файла.
     * @throws IOException Если возникла ошибка при чтении файла.
     */
    protected abstract MyArrayList<T> fileInput(String filePath) throws IOException;

    /**
     * Метод для создания ключа поиска. Этот метод должен быть реализован в наследниках.
     *
     * @return Объект {@link Key}, используемый для поиска.
     */
    protected abstract Key<T> createKey();

    /**
     * Путь для вывода и ввода данных в тестовой директории.
     */
    protected final String OUTPUT_INPUT_PATH = "src/test/resources/";

    /**
     * Метод, обрабатывающий выбор пользователя для ввода данных (из файла, случайных данных или вручную).
     *
     * @param scanner Объект {@link Scanner} для чтения ввода от пользователя.
     */
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

    /**
     * Обработка ввода данных вручную, создание списка и печать его.
     *
     * @param scanner Объект {@link Scanner} для чтения ввода от пользователя.
     */
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

    /**
     * Обработка ввода данных из файла.
     *
     * @param scanner Объект {@link Scanner} для чтения ввода от пользователя.
     * @throws IOException Если возникла ошибка при чтении файла.
     */
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла: ");
        String filePath = OUTPUT_INPUT_PATH + scanner.next() + ".txt";
        scanner.nextLine();

        MyArrayList<T> items = fileInput(filePath);
        processAndPrint(items);
    }

    /**
     * Обработка ввода случайных данных.
     *
     * @param scanner Объект {@link Scanner} для чтения ввода от пользователя.
     * @throws IOException Если возникла ошибка при чтении данных.
     */
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

    /**
     * Обработка списка, сортировка его методом Шелла, вывод на экран и запись в файл.
     *
     * @param items Список объектов типа {@link T}, которые нужно обработать.
     */
    private void processAndPrint(MyArrayList<T> items) {
        MyArrayList<T> sortedItems = items.copy();
        ShellSort<T> shellSort = new ShellSort<>();
        shellSort.sort(sortedItems);

        System.out.println("======== Исходный список ========");
        items.toPrint();
        System.out.println("======== Отсортированный список ========");
        sortedItems.toPrint();

        performBinarySearch(sortedItems);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_INPUT_PATH + "output.txt", true));
             PrintWriter writer = new PrintWriter(bufferedWriter)) {
            writer.println("======== Исходный список ========");
            writer.write(items.toString());
            writer.println("======== Отсортированный список ========");
            writer.write(sortedItems.toString());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл ", e);
        }
    }

    /**
     * Выполнение бинарного поиска по отсортированным данным и запись результата в файл.
     *
     * @param sortedItems Отсортированный список объектов для поиска.
     */
    private void performBinarySearch(MyArrayList<T> sortedItems) {
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        Scanner scanner = new Scanner(System.in);
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<T> binarySearch = new BinarySearch<>();
            Key<T> searchKey = createKey();
            int index = binarySearch.binarySearch(sortedItems, searchKey.getValue());

            try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_INPUT_PATH + "search_key.txt", true))) {
                String result = (index != -1)
                        ? "Элемент " + searchKey.getValue() + " найден по индексу: " + index
                        : "Элемент " + searchKey.getValue() + " не найден.";
                System.out.println(result);
                writer.println(result);
            } catch (IOException e) {
                System.out.println("Ошибка в чтении файла: " + e.getMessage());
            }
        }
    }
}
