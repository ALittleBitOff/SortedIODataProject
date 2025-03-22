package io;

import CustomList.MyArrayList;
import data.Korneplod;
import io.manualInput.KorneplodDataInput;
import io.textInput.FileReaderDataInput;
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

        // Создание массива корнеплодов
        MyArrayList<Korneplod> korneplods = KorneplodDataInput.createKorneplodArrayFromConsole(length);

        //Сортировка списка корнеплодов
        MyArrayList<Korneplod> sortKorneplods = korneplods.copy();
        ShellSort<Korneplod> shellKorneplodsSort = new ShellSort<>();
        shellKorneplodsSort.sort(sortKorneplods);

        // Вывод созданных книг
        System.out.println("Cписок корнеплодов:");
        for (int i = 0; i < korneplods.size(); i++) {
            System.out.println(korneplods.get(i).toString());
        }

        // Вывод созданных корнеплодов
        System.out.println("Отсортированный список корнеплодов:");
        for (int i = 0; i < sortKorneplods.size(); i++) {
            System.out.println(sortKorneplods.get(i).toString());
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
        for (int i = 0; i < korneplods.size(); i++) {
            System.out.println(korneplods.get(i).toString());
        }

        // Вывод созданных корнеплодов
        System.out.println("Отсортированный список корнеплодов:");
        for (int i = 0; i < sortKorneplods.size(); i++) {
            System.out.println(sortKorneplods.get(i).toString());
        }
    }
}