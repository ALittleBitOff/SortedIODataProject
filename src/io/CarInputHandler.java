package io;

import data.Car;

import java.util.Scanner;

public class CarInputHandler implements DataInputHandler {
    @Override
    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных для автомобиля:");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных вручную");

        int subChoice = scanner.nextInt();
        switch (subChoice) {
            case 1:
                System.out.println("Ввод данных для автомобиля из файла.");
                // Логика для ввода из файла
                break;
            case 2:
                System.out.println("Ввод случайных данных для автомобиля.");
                // Логика для ввода случайных данных
                break;
            case 3:
                System.out.println("Ввод данных для автомобиля вручную.");
                handleManualInput(scanner);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private void handleManualInput(Scanner scanner) {
        System.out.print("Введите количество автомобилей: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создание массива автомобилей
        Car[] cars = CarDataInput.createCarArrayFromConsole(length);

        // Вывод созданных автомобилей
        System.out.println("Список автомобилей:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}