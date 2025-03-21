package io;

import data.Korneplod;
import io.manualInput.KorneplodDataInput;
import io.textInput.FileReaderDataInput;

import java.io.IOException;
import java.util.List;
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
        Korneplod[] korneplods = KorneplodDataInput.createKorneplodArrayFromConsole(length);

        // Вывод созданного списка корнеплодов
        System.out.println("Список корнеплодов:");
        for (Korneplod korneplod : korneplods) {
            System.out.println(korneplod);
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/korneplod/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println(filePath);
        List<Korneplod> korneplods = FileReaderDataInput.readKorneplodFromFile(filePath);

        // Вывод созданных автомобилей
        System.out.println("Список автомобилей:");
        for (Korneplod korneplod  : korneplods) {
            System.out.println(korneplod);
        }
    }
}