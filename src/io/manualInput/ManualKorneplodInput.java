package io.manualInput;

import data.Korneplod;

/**
 * Класс для ручного ввода данных о корнеплодах.
 * <br>
 * Наследует абстрактный класс {@link ManualDataInput}, предоставляя реализацию метода
 * {@link ManualDataInput#createObject()} для создания объекта типа {@link Korneplod}.
 */
public class ManualKorneplodInput extends ManualDataInput<Korneplod> {

    /**
     * Метод для создания объекта типа {@link Korneplod} на основе ввода данных пользователем.
     * <br>
     * Вводятся данные о корнеплоде: тип, масса и цвет.
     *
     * @return Созданный объект {@link Korneplod}, собранный с помощью {@link Korneplod.Builder}.
     */
    @Override
    protected Korneplod createObject() {
        System.out.println("Введите тип корнеплода (String): ");
        String type = scanner.nextLine();

        System.out.println("Введите массу (double): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите цвет (String): ");
        String color = scanner.nextLine();

        return new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }
}
