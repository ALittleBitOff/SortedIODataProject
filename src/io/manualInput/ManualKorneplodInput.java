package io.manualInput;

import data.Korneplod;

public class ManualKorneplodInput extends ManualDataInput<Korneplod> {

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
