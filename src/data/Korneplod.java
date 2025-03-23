package data;

import java.io.Serial;
import java.io.Serializable;

public class Korneplod implements Comparable<Korneplod>, Serializable, Sortable{
    @Serial
    private static final long serialVersionUID = 1L;

    private final String type;
    private final double weight;
    private final String color;

    private Korneplod(Builder builder) {
        this.type = validateType(builder.type);
        this.weight = validateWeight(builder.weight);
        this.color = validateColor(builder.color);
    }

    //Валидация названия корнеплода
    private String validateType(String type) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Название корнеплода не может быть пустым или null");
        }
        if (!type.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Название корнеплода не соответствует регулярному выражению");
        }
        return type.trim();
    }

    // Валидация массы
    private double validateWeight(double weight) {
        if (Double.isNaN(weight)) {
            throw new IllegalArgumentException("Масса корнеплода не может иметь значение NaN");
        }
        if (Double.isInfinite(weight)) {
            throw new IllegalArgumentException("Масса не может быть бесконечной");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Масса должна быть положительной");
        }
        return weight;
    }

    //Валидация цвет корнеплода
    private String validateColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет корнеплода не может быть пустым или null");
        }
        if (!color.matches("[a-zA-Zа-яА-Я-]+")) {
            throw new IllegalArgumentException("Цвет корнеплода не соответствует регулярному выражению");
        }
        return color.trim();
    }

    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Korneplod build() {
            return new Korneplod(this);
        }
    }

    @Override
    public int compareTo(Korneplod otherKorneplod) {

        // 1. Сравнение по типу
        int typeComparison = this.type.compareTo(otherKorneplod.type);
        if (typeComparison != 0) {
            return typeComparison;
        }

        // 2. Сравнение по весу
        int weightComparison = Double.compare(this.weight, otherKorneplod.weight);
        if (weightComparison != 0) {
            return weightComparison;
        }

        // 3. Сравнение по цвету
        return this.color.compareTo(otherKorneplod.color);
    }

    //Доп.Задание. Реализация метода Sortable.
    @Override
    public String getSortingKey() {
        return "Korneplod {" +
                "type: " + type +
                ", weight: " + weight +
                ", color: " + color +
                '}';
    }

    @Override
    public String toString() {
        return "Korneplod {" +
                "type: " + type +
                ", weight: " + weight +
                ", color: " + color +
                '}';
    }
}
