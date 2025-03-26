package io.manualInput;

import data.Car;

/**
 * Класс для ручного ввода данных о автомобиле.
 * <br>
 * Наследует абстрактный класс {@link ManualDataInput}, предоставляя реализацию метода
 * {@link ManualDataInput#createObject()} для создания объекта типа {@link Car}.
 */
public class ManualCarInput extends ManualDataInput<Car> {

    /**
     * Метод для создания объекта типа {@link Car} на основе ввода данных пользователем.
     * <br>
     * Вводятся данные о автомобиле: мощность, модель и год изготовления.
     *
     * @return Созданный объект {@link Car}, собранный с помощью {@link Car.Builder}.
     */
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
                .setHorsePower(power)
                .setModel(model)
                .setReleaseYear(year)
                .build();
    }
}
