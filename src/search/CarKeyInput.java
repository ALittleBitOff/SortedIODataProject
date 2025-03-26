package search;

import data.Car;

/**
 * Класс для создания ключа поиска для объекта типа {@link Car}.
 * <br>
 * Этот класс получает данные для создания ключа (мощность, модель, год изготовления)
 * с помощью ввода пользователя.
 */
public class CarKeyInput extends KeyInput<Car> {

    /**
     * Метод для создания ключа поиска для автомобиля.
     * <br>
     * Запрашивает у пользователя данные (мощность, модель, год изготовления),
     * а затем создает объект типа {@link Key} с этим ключом.
     *
     * @return Ключ, созданный для автомобиля, содержащий мощность, модель и год изготовления.
     */
    @Override
    public Key<Car> createKey() {
        // Запрашиваем у пользователя информацию о машине
        int power = getIntInput("Введите мощность (int): ");
        String model = getStringInput("Введите модель (String): ");
        int year = getIntInput("Введите год изготовления (int): ");

        // Создаем и возвращаем новый ключ с помощью Builder
        return new Key<>(new Car.Builder()
                .setHorsePower(power)
                .setModel(model)
                .setReleaseYear(year)
                .build());
    }
}
