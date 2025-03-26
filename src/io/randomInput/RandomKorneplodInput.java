package io.randomInput;

import data.Korneplod;

/**
 * Класс для генерации случайных объектов типа {@link Korneplod}.
 * <br>
 * Этот класс реализует метод {@link RandomDataInput#createRandomObject()} для создания
 * случайных корнеплодов, с выбором случайного типа, веса и цвета.
 * <br>
 * Типы корнеплодов и их цвета генерируются из заранее определенных массивов,
 * а вес корнеплода генерируется случайным образом в пределах от 0.1 до 2.0 кг.
 */
public class RandomKorneplodInput extends RandomDataInput<Korneplod> {

    /** Массив с возможными типами корнеплодов. */
    private static final String[] TYPES = {
            "Carrot",
            "Potato",
            "Beetroot",
            "Radish"
    };

    /** Массив с возможными цветами корнеплодов. */
    private static final String[] COLORS = {
            "Orange",
            "Brown",
            "Purple",
            "Red"
    };

    /**
     * Создание случайного объекта типа {@link Korneplod}.
     * <br>
     * Метод выбирает случайный тип корнеплода из массива {@link #TYPES},
     * случайный цвет из массива {@link #COLORS} и генерирует случайный вес
     * от 0.1 до 2.0 кг.
     *
     * @return Случайно сгенерированный объект {@link Korneplod}.
     */
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
