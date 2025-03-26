package io.manualInput;

import data.Car;

public class ManualCarInput extends ManualDataInput<Car> {

    @Override
    protected Car createObject() {
        System.out.println("Введите мощность (int): ");
        int power = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите модель (String): ");
        String model = scanner.nextLine();

        System.out.println("Введите год изготовления (int): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        return new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
    }
}
