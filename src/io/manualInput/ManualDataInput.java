package io.manualInput;

import CustomList.MyArrayList;
import java.util.Scanner;

/**
 * Абстрактный класс для ручного ввода данных.
 * <br>
 * Этот класс использует шаблон для ввода данных типа {@link T}, предоставляя абстрактный метод
 * {@link #createObject()}, который должен быть реализован в подклассах для создания объектов.
 */
public abstract class ManualDataInput<T> {

    // Статический сканер для ввода данных пользователем
    protected static final Scanner scanner = new Scanner(System.in);

    /**
     * Абстрактный метод для создания объекта типа {@link T}.
     * <br>
     * Этот метод должен быть реализован в наследуемых классах для ввода и создания конкретных объектов.
     *
     * @return объект типа {@link T}.
     */
    protected abstract T createObject();

    /**
     * Метод для ввода массива объектов типа {@link T}.
     * <br>
     * Метод позволяет создать и заполнить список объектов с помощью метода {@link #createObject()}.
     *
     * @param length количество элементов в создаваемом списке.
     * @return список объектов типа {@link T}, введённых пользователем.
     */
    public MyArrayList<T> manualDataInputArray(int length) {
        MyArrayList<T> items = new MyArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Элемент номер: " + i);
            items.add(createObject()); // Вызываем реализацию из наследника
        }
        return items;
    }
}
