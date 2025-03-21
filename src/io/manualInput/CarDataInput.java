package io.manualInput;

import data.Car;
import java.util.Scanner;

public class CarDataInput{

    public static Car createCarFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите мощность (int): ");
        int power = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите модель (String): ");
        String model = scanner.nextLine();

        System.out.print("Введите год изготовления (int): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        return new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
    }

    public static Car[] createCarArrayFromConsole(int length) {
        Car[] cars = new Car[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Введите количество машин " + (i + 1) + ":");
            cars[i] = createCarFromConsole();
        }
        return cars;
    }
}