package io.randomInput;

import CustomList.MyArrayList;
import java.util.Random;

/**
 * Абстрактный класс для генерации случайных объектов.
 * <br>
 * Класс используется для создания случайных объектов типа {@link T},
 * с использованием метода {@link Random#nextInt(int)}.
 * <br>
 * Конкретные реализации для различных типов объектов должны наследовать
 * этот класс и реализовывать метод {@link RandomDataInput#createRandomObject()}.
 *
 * @param <T> Тип объектов, которые будут генерироваться случайным образом.
 */
public abstract class RandomDataInput<T> {

    /** Экземпляр класса Random для генерации случайных чисел. */
    protected static final Random random = new Random();

    /**
     * Метод для создания случайного объекта типа {@link T}.
     * <br>
     * Этот метод должен быть реализован в наследниках для создания объектов
     * конкретных типов.
     *
     * @return Случайно сгенерированный объект типа {@link T}.
     */
    protected abstract T createRandomObject();

    /**
     * Метод для создания списка случайных объектов заданной длины.
     * <br>
     * Метод создает список объектов типа {@link T}, заполняя его с помощью
     * метода {@link RandomDataInput#createRandomObject()}.
     *
     * @param length Длина списка.
     * @return Список {@link MyArrayList}, содержащий случайно сгенерированные объекты.
     */
    public MyArrayList<T> createRandomInputArray(int length) {
        MyArrayList<T> items = new MyArrayList<>();
        for (int i = 0; i < length; i++) {
            items.add(createRandomObject());
        }
        return items;
    }
}
