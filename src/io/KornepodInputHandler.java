package io;

import CustomList.MyArrayList;
import data.Korneplod;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import search.BinarySearch;
import search.Key;
import search.KeyInput;
import sort.ShellSort;

import java.io.IOException;
import java.util.Scanner;

public class KornepodInputHandler implements DataInputHandler {
    @Override
    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных для корнеплодов:");
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
                System.out.println("Ввод случайных данных");
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
        System.out.print("Введите количество корнеплодов: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество корнеплодов не может быть отрицательным: " + length);
        }

        // Создание массива корнеплодов
        MyArrayList<Korneplod> korneplods = ManualDataInput.manualKorneplodDataInput(length);

        //Сортировка списка корнеплодов
        MyArrayList<Korneplod> sortKorneplods = korneplods.copy();
        ShellSort<Korneplod> shellKorneplodsSort = new ShellSort<>();
        shellKorneplodsSort.sort(sortKorneplods);

        // Вывод созданных книг
        System.out.println("Cписок корнеплодов:");
        korneplods.toPrint();

        // Вывод созданных корнеплодов
        System.out.println("Отсортированный список корнеплодов:");
        sortKorneplods.toPrint();

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Korneplod> binaryCarSearch = new BinarySearch<>();
            Key<Korneplod> searchKey = KeyInput.createKornepodKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortKorneplods, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/korneplod/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println("Путь до считываемого файла "+filePath);

        //Список корнеплодов
        MyArrayList<Korneplod> korneplods = FileReaderDataInput.readKorneplodFromFile(filePath);

        //Сортировка списка корнеплодов
        MyArrayList<Korneplod> sortKorneplods = korneplods.copy();
        ShellSort<Korneplod> shellKorneplodsSort = new ShellSort<>();
        shellKorneplodsSort.sort(sortKorneplods);

        // Вывод созданных книг
        System.out.println("Cписок корнеплодов:");
        korneplods.toPrint();

        // Вывод созданных корнеплодов
        System.out.println("Отсортированный список корнеплодов:");
        sortKorneplods.toPrint();

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Korneplod> binaryCarSearch = new BinarySearch<>();
            Key<Korneplod> searchKey = KeyInput.createKornepodKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortKorneplods, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }

    @Override
    public void dataRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество корнеплодов: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество корнеплодов не может быть отрицательным: " + length);
        }

        //Список корнеплодов
        MyArrayList<Korneplod> korneplods = RandomDataInput.createKornepodRandomInputArray(length);

        //Сортировка списка корнеплодов
        MyArrayList<Korneplod> sortKorneplods = korneplods.copy();
        ShellSort<Korneplod> shellKorneplodsSort = new ShellSort<>();
        shellKorneplodsSort.sort(sortKorneplods);

        // Вывод созданных книг
        System.out.println("Cписок корнеплодов:");
        korneplods.toPrint();

        // Вывод созданных корнеплодов
        System.out.println("Отсортированный список корнеплодов:");
        sortKorneplods.toPrint();

        //Бинарный поиск элемента
        System.out.println("Хотите произвести бинарный поиск элемента? (1 - Да, 2 - Нет)");
        int continueChoice = scanner.nextInt();
        if (continueChoice == 1) {
            BinarySearch<Korneplod> binaryCarSearch = new BinarySearch<>();
            Key<Korneplod> searchKey = KeyInput.createKornepodKey();
            // Вывод результата
            int index = binaryCarSearch.binarySearch(sortKorneplods, searchKey.getValue());
            if (index != -1) {
                System.out.println("Элемент " + searchKey.getValue() + " найден по индексу: " + index);
            } else {
                System.out.println("Элемент " + searchKey.getValue() + " не найден в массиве.");
            }
        }
    }
}