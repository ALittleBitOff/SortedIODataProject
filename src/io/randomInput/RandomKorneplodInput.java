package io.randomInput;

import data.Korneplod;

public class RandomKorneplodInput extends RandomDataInput<Korneplod> {

    private static final String[] TYPES = {
            "Carrot",
            "Potato",
            "Beetroot",
            "Radish"
    };
    private static final String[] COLORS = {
            "Orange",
            "Brown",
            "Purple",
            "Red"
    };

    @Override
    protected Korneplod createRandomObject() {
        String type = TYPES[random.nextInt(TYPES.length)];
        double weight = Math.round((0.1 + random.nextDouble() * 2.0) * 100.0) / 100.0; // Вес от 0.1 до 2.0 кг
        String color = COLORS[random.nextInt(COLORS.length)];

        return new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }
}
