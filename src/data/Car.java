package data;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int HorsePower;
    private String Model;
    private int ReleaseYear;

    private Car(Builder builder) {
        this.HorsePower = builder.HorsePower;
        this.Model = builder.Model;
        this.ReleaseYear = builder.ReleaseYear;
    }

    public static class Builder {
        private int HorsePower;
        private String Model;
        private int ReleaseYear;

        public Builder setHorsePower(int horsePower) {
            this.HorsePower = horsePower;
            return this;
        }

        public Builder setModel(String model) {
            this.Model = model;
            return this;
        }

        public Builder setReleaseYear(int releaseYear) {
            this.ReleaseYear = releaseYear;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    @Override
    public String toString() {
        return "Машина {" +
                "Мощность: " + HorsePower +
                ", Модель: " + Model +
                ", Год выпуска: " + ReleaseYear +
                "}";
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.HorsePower, otherCar.HorsePower);
    }
}
