package data;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int horsePower;
    private String model;
    private int releaseYear;

    private Car(Builder builder) {
        this.horsePower = builder.horsePower;
        this.model = builder.model;
        this.releaseYear = builder.releaseYear;
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
    public String toString() {
        return "Машина {" +
                "Мощность: " + horsePower +
                ", Модель: " + model +
                ", Год выпуска: " + releaseYear +
                "}";
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.horsePower, otherCar.horsePower);
    }
}
