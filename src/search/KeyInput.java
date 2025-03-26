package search;

import java.util.Scanner;

/**
 * Абстрактный класс для ввода данных, необходимых для создания ключа поиска.
 * <br>
 * Классы, наследующие этот класс, должны реализовать метод {@link #createKey()},
 * который будет создавать ключ, используя введенные данные.
 *
 * @param <T> Тип, который будет использоваться в качестве значения ключа.
 */
public abstract class KeyInput<T> {
    protected Scanner scanner = new Scanner(System.in);

    /**
     * Абстрактный метод для создания ключа с использованием данных, введенных пользователем.
     *
     * @return Созданный ключ типа {@link Key}.
     */
    public abstract Key<T> createKey();

    /**
     * Метод для получения строкового ввода от пользователя.
     *
     * @param prompt Текст, который будет отображаться перед вводом.
     * @return Введенная строка.
     */
    protected String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Метод для получения целочисленного ввода от пользователя.
     *
     * @param prompt Текст, который будет отображаться перед вводом.
     * @return Введенное целое число.
     */
    protected int getIntInput(String prompt) {
        System.out.print(prompt);
        int value = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        return value;
    }

    /**
     * Метод для получения ввода типа double от пользователя.
     *
     * @param prompt Текст, который будет отображаться перед вводом.
     * @return Введенное значение типа double.
     */
    protected double getDoubleInput(String prompt) {
        System.out.print(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine(); // Очистка буфера
        return value;
    }
}
