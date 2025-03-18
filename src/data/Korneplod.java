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
        return Double.compare(this.weight, otherKorneplod.weight);
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
