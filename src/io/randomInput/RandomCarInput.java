package io.randomInput;

import data.Car;

/**
 * Класс для случайного генератора данных о автомобилях.
 * <br>
 * Наследует абстрактный класс {@link RandomDataInput}, предоставляя реализацию метода
 * {@link RandomDataInput#createRandomObject()} для создания объекта типа {@link Car}.
 */
public class RandomCarInput extends RandomDataInput<Car> {

    /** Массив возможных моделей автомобилей для случайного выбора. */
    private static final String[] CAR_MODELS = {
            "Toyota Camry",
            "Honda Accord",
            "Ford Mustang",
            "BMW X5",
            "Audi A4",
            "Tesla Model S"
    };

    /**
     * Метод для случайного создания объекта типа {@link Car}.
     * <br>
     * Генерирует случайные данные о автомобиле, выбирая модель, мощность и год выпуска.
     * <br>
     * Мощность генерируется случайным образом в пределах от 50 до 500 л.с.
     * <br>
     * Год выпуска генерируется случайным образом в пределах от 2000 до 2023 года.
     *
     * @return Созданный объект {@link Car}, собранный с помощью {@link Car.Builder}.
     */
    @Override
    protected Car createRandomObject() {
        int power = 50 + random.nextInt(451); // Мощность от 50 до 500 л.с.
        String model = CAR_MODELS[random.nextInt(CAR_MODELS.length)];
        int year = 2000 + random.nextInt(24); // Год от 2000 до 2023

        return new Car.Builder()
                .setHorsePower(power)
                .setModel(model)
                .setReleaseYear(year)
                .build();
    }
}
