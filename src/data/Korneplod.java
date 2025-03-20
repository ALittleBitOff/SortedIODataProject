package data;

import java.io.Serial;
import java.io.Serializable;

public class Korneplod implements Comparable<Korneplod>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String type;
    private double weight;
    private String color;

    private Korneplod(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
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

    @Override
    public String toString() {
        return "Korneplod {" +
                "type: " + type +
                ", weight: " + weight +
                ", color: " + color +
                '}';
    }
}
