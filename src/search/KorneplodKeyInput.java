package search;

import data.Korneplod;

public class KorneplodKeyInput extends KeyInput<Korneplod> {
    @Override
    public Key<Korneplod> createKey() {
        String type = getStringInput("Введите тип (String): ");
        double weight = getDoubleInput("Введите массу (double): ");
        String color = getStringInput("Введите цвет (String): ");

        return new Key<>(new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build());
    }
}