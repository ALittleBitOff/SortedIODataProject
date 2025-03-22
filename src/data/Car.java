package data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Car implements Comparable<Car>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int horsePower;
    private String model;
    private int releaseYear;

    public Car(Builder builder) {
        this.horsePower = builder.horsePower;
        this.model = builder.model;
        this.releaseYear = builder.releaseYear;
    }

    public Car(int power, String model, int year) {
    }

    public static class Builder {
        private int horsePower;
        private String model;
        private int releaseYear;

        public Builder sethorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        public Builder setmodel(String model) {
            this.model = model;
            return this;
        }

        public Builder setreleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public int compareTo(Car otherCar) {

        // 1. Сравнение по мощности
        int powerComparison = Integer.compare(this.horsePower, otherCar.horsePower);
        if (powerComparison != 0) {
            return powerComparison;
        }

        // 2. Сравнение по модели
        int modelComparison = this.model.compareTo(otherCar.model);
        if (modelComparison != 0) {
            return modelComparison;
        }

        // 3. Сравнение по году
        return Integer.compare(this.releaseYear, otherCar.releaseYear);
    }

    @Override
    public String toString() {
        return "Машина {" +
                "Мощность: " + horsePower +
                ", Модель: " + model +
                ", Год выпуска: " + releaseYear +
                "}";
    }
}
