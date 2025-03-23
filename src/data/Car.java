package data;

import java.io.Serial;
import java.io.Serializable;

public class Car implements Comparable<Car>, Serializable, Sortable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final int horsePower;
    private final String model;
    private final int releaseYear;

    private Car(Builder builder) {
        this.horsePower = validatePower(builder.horsePower);
        this.model = validateModel(builder.model);
        this.releaseYear =validateYear(builder.releaseYear);
    }

    // Валидация мощности автомобиля
    private int validatePower(int horsePower) {
        if (horsePower <= 0) {
            throw new IllegalArgumentException("Мощность автомобиля должна быть положительной (л.с.)");
        }
        return horsePower;
    }

    // Валидация названия автомобиля
    private String validateModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Название автомобиля не может быть пустым или null");
        }
        if (!model.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Название автомобиля не соответствует регулярному выражению");
        }
        return model.trim();
    }

    // Валидация года изготовления
    private int validateYear(int releaseYear) {
        if (releaseYear <= 1500) {
            throw new IllegalArgumentException("Год изготовления автомобиля должна быть положительным (л.с.) и не ранее 1500 года");
        }
        return releaseYear;
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



    //Доп.Задание. Реализация метода Sortable.
    @Override
    public String getSortingKey() {
        return "Машина {" +
                "Мощность: " + horsePower +
                ", Модель: " + model +
                ", Год выпуска: " + releaseYear +
                "}";
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
