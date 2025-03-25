package io.textInput;

import data.Car;

public class FileCarInput  extends FileReaderDataInput<Car> {
    @Override
    protected Car parseLine(String[] parts) throws NumberFormatException {
        int power = Integer.parseInt(parts[0].trim());
        String model = parts[1].trim();
        int year = Integer.parseInt(parts[2].trim());
        return new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
    }
}
