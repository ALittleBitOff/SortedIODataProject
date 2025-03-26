package data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Класс, представляющий автомобиль с мощностью, моделью и годом выпуска.
 * <br>
 * Реализует интерфейсы {@link Comparable} для сортировки и {@link Serializable} для возможности сериализации.
 */
public class Car implements Comparable<Car>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int horsePower;
    private final String model;
    private final int releaseYear;

    /**
     * Приватный конструктор автомобиля, принимающий {@link Builder} для создания объекта автомобиля.
     *
     * @param builder Строитель, содержащий параметры для автомобиля.
     */
    private Car(Builder builder) {
        this.horsePower = validatePower(builder.horsePower);
        this.model = validateModel(builder.model);
        this.releaseYear = validateYear(builder.releaseYear);
    }

    /**
     * Валидация мощности автомобиля.
     * <br>
     * Проверяет, что мощность автомобиля больше нуля.
     *
     * @param horsePower Мощность автомобиля в лошадиных силах.
     * @return Валидированная мощность автомобиля.
     * @throws IllegalArgumentException Если мощность меньше или равна нулю.
     */
    private int validatePower(int horsePower) {
        if (horsePower <= 0) {
            throw new IllegalArgumentException("Мощность автомобиля должна быть положительной (л.с.)");
        }
        return horsePower;
    }

    /**
     * Валидация модели автомобиля.
     * <br>
     * Проверяет, что модель не пустая, не null, и соответствует регулярному выражению.
     *
     * @param model Модель автомобиля.
     * @return Валидированная модель автомобиля.
     * @throws IllegalArgumentException Если модель пустая, null или не соответствует регулярному выражению.
     */
    private String validateModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Название автомобиля не может быть пустым или null");
        }
        if (!model.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Название автомобиля не соответствует регулярному выражению");
        }
        return model.trim();
    }

    /**
     * Валидация года выпуска автомобиля.
     * <br>
     * Проверяет, что год выпуска больше 1500.
     *
     * @param releaseYear Год выпуска автомобиля.
     * @return Валидированный год выпуска.
     * @throws IllegalArgumentException Если год выпуска меньше или равен 1500.
     */
    private int validateYear(int releaseYear) {
        if (releaseYear <= 1500) {
            throw new IllegalArgumentException("Год изготовления автомобиля должен быть положительным (л.с.) и не ранее 1500 года");
        }
        return releaseYear;
    }

    /**
     * Строитель для создания экземпляров автомобиля.
     */
    public static class Builder {
        private int horsePower;
        private String model;
        private int releaseYear;

        /**
         * Устанавливает мощность автомобиля.
         *
         * @param horsePower Мощность автомобиля в лошадиных силах.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setHorsePower(int horsePower) {
            this.horsePower = horsePower;
            return this;
        }

        /**
         * Устанавливает модель автомобиля.
         *
         * @param model Модель автомобиля.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Устанавливает год выпуска автомобиля.
         *
         * @param releaseYear Год выпуска автомобиля.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setReleaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        /**
         * Строит экземпляр автомобиля с указанными параметрами.
         *
         * @return Новый объект {@link Car}.
         */
        public Car build() {
            return new Car(this);
        }
    }

    /**
     * Сравнивает текущий автомобиль с другим автомобилем.
     * <br>
     * Сначала сравнивается мощность, затем модель, и, если необходимо, год выпуска.
     *
     * @param otherCar Другой автомобиль для сравнения.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(Car otherCar) {
        return Comparator.comparing(Car::getHorsePower)
                .thenComparing(Car::getModel)
                .thenComparing(Car::getReleaseYear)
                .compare(this, otherCar);
    }

    /**
     * Получает мощность автомобиля.
     *
     * @return Мощность автомобиля в лошадиных силах.
     */
    public int getHorsePower() {
        return horsePower;
    }

    /**
     * Получает модель автомобиля.
     *
     * @return Модель автомобиля.
     */
    public String getModel() {
        return model;
    }

    /**
     * Получает год выпуска автомобиля.
     *
     * @return Год выпуска автомобиля.
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    /**
     * Возвращает строковое представление автомобиля.
     *
     * @return Строковое представление автомобиля.
     */
    @Override
    public String toString() {
        return String.format("Машина { Мощность: %s, Модель: %s, Год выпуска: %s }", horsePower, model, releaseYear);
    }
}
