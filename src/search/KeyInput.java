package search;

import java.util.Scanner;

public abstract class KeyInput<T> {
    protected Scanner scanner = new Scanner(System.in);

    public abstract Key<T> createKey();

    protected String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    protected int getIntInput(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return value;
    }

    protected double getDoubleInput(String prompt) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        return value;
    }
}
