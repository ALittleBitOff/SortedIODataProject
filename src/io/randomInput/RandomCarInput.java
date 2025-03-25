package io.randomInput;

import data.Car;

public class RandomCarInput extends RandomDataInput<Car> {

    private static final String[] CAR_MODELS = {
            "Toyota Camry",
            "Honda Accord",
            "Ford Mustang",
            "BMW X5",
            "Audi A4",
            "Tesla Model S"
    };

    @Override
    protected Car createRandomObject() {
        int power = 50 + random.nextInt(451);
        String model = CAR_MODELS[random.nextInt(CAR_MODELS.length)];
        int year = 1500 + random.nextInt(24); // Год от 1500 до 2023

        return new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
    }
}
