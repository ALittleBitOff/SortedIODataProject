package io;

import data.Korneplod;

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
                break;
            case 2:
                System.out.println("Ввод случайных данных");
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

    public void handleManualInput(Scanner scanner) {
        System.out.print("Введите количество корнеплодов: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создание массива автомобилей
        Korneplod[] korneplods = KorneplodDataInput.createKorneplodArrayFromConsole(length);

        // Вывод созданных автомобилей
        System.out.println("Список корнеплодов:");
        for (Korneplod korneplod : korneplods) {
            System.out.println(korneplod);
        }
    }
}