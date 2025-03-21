package io.manualInput;

import data.Korneplod;
import java.util.Scanner;

public class KorneplodDataInput {

    public static Korneplod createKorneplodFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите тип (String): ");
        String type = scanner.nextLine();

        System.out.print("Введите массу (double): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите цвет (String): ");
        String color = scanner.nextLine();

        return new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }
    public static Korneplod[] createKorneplodArrayFromConsole(int length) {
        Korneplod[] korneplods = new Korneplod[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Введите количество корнеплодов " + (i + 1) + ":");
            korneplods[i] = createKorneplodFromConsole();
        }
        return korneplods;
    }
}
