package data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Класс, представляющий корнеплод с типом, весом и цветом.
 * <br>
 * Реализует интерфейсы {@link Comparable} для сортировки и {@link Serializable} для возможности сериализации.
 */
public class Korneplod implements Comparable<Korneplod>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String type;
    private final double weight;
    private final String color;

    /**
     * Приватный конструктор, принимающий {@link Builder} для создания объекта корнеплода.
     *
     * @param builder Строитель, содержащий параметры для корнеплода.
     */
    private Korneplod(Builder builder) {
        this.type = validateType(builder.type);
        this.weight = validateWeight(builder.weight);
        this.color = validateColor(builder.color);
    }

    /**
     * Валидация типа корнеплода.
     * <br>
     * Проверяет, что тип не null, не пуст и соответствует регулярному выражению.
     *
     * @param type Тип корнеплода.
     * @return Валидированный тип.
     * @throws IllegalArgumentException Если тип пустой, null или не соответствует регулярному выражению.
     */
    private String validateType(String type) {
        Objects.requireNonNull(type, "Название корнеплода не может быть null");
        if (type.trim().isEmpty()) {
            throw new IllegalArgumentException("Название корнеплода не может быть пустым");
        }
        if (!type.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Название корнеплода содержит недопустимые символы");
        }
        return type.trim();
    }

    /**
     * Валидация веса корнеплода.
     * <br>
     * Проверяет, что вес положительный и конечный.
     *
     * @param weight Вес корнеплода.
     * @return Валидированный вес.
     * @throws IllegalArgumentException Если вес не положительный или является NaN/бесконечностью.
     */
    private double validateWeight(double weight) {
        if (Double.isNaN(weight) || Double.isInfinite(weight) || weight <= 0) {
            throw new IllegalArgumentException("Масса должна быть положительной и конечной");
        }
        return weight;
    }

    /**
     * Валидация цвета корнеплода.
     * <br>
     * Проверяет, что цвет не null, не пуст и соответствует регулярному выражению.
     *
     * @param color Цвет корнеплода.
     * @return Валидированный цвет.
     * @throws IllegalArgumentException Если цвет пустой, null или не соответствует регулярному выражению.
     */
    private String validateColor(String color) {
        Objects.requireNonNull(color, "Цвет корнеплода не может быть null");
        if (color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет корнеплода не может быть пустым");
        }
        if (!color.matches("[a-zA-Zа-яА-Я-]+")) {
            throw new IllegalArgumentException("Цвет корнеплода содержит недопустимые символы");
        }
        return color.trim();
    }

    /**
     * Строитель для создания экземпляров {@link Korneplod}.
     */
    public static class Builder {
        private String type;
        private double weight;
        private String color;

        /**
         * Устанавливает тип корнеплода.
         *
         * @param type Тип корнеплода.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        /**
         * Устанавливает вес корнеплода.
         *
         * @param weight Вес корнеплода в килограммах.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        /**
         * Устанавливает цвет корнеплода.
         *
         * @param color Цвет корнеплода.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        /**
         * Строит экземпляр корнеплода с указанными параметрами.
         *
         * @return Новый объект {@link Korneplod}.
         */
        public Korneplod build() {
            return new Korneplod(this);
        }
    }

    /**
     * Сравнивает текущий корнеплод с другим корнеплодом.
     * <br>
     * Сначала сравнивается тип, затем вес, и, если необходимо, цвет.
     *
     * @param otherKorneplod Другой корнеплод для сравнения.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(Korneplod otherKorneplod) {
        return Comparator.comparing(Korneplod::getType)
                .thenComparing(Korneplod::getWeight)
                .thenComparing(Korneplod::getColor)
                .compare(this, otherKorneplod);
    }

    /**
     * Получает тип корнеплода.
     *
     * @return Тип корнеплода.
     */
    public String getType() {
        return type;
    }

    /**
     * Получает вес корнеплода.
     *
     * @return Вес корнеплода в килограммах.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Получает цвет корнеплода.
     *
     * @return Цвет корнеплода.
     */
    public String getColor() {
        return color;
    }

    /**
     * Возвращает строковое представление корнеплода.
     *
     * @return Строковое представление корнеплода.
     */
    @Override
    public String toString() {
        return String.format("Корнеплод { Тип: %s, Вес: %s кг, Цвет: %s }", type, weight, color);
    }
}
