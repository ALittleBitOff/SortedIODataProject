package search;

import data.Car;

public class CarKeyInput extends KeyInput<Car> {
    @Override
    public Key<Car> createKey() {
        int power = getIntInput("Введите мощность (int): ");
        String model = getStringInput("Введите модель (String): ");
        int year = getIntInput("Введите год изготовления (int): ");

        return new Key<>(new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build());
    }
}