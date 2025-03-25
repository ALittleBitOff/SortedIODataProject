package io.randomInput;

import CustomList.MyArrayList;
import java.util.Random;


public abstract class RandomDataInput<T>{
    protected static final Random random = new Random();

    // Метод для генерации случайного объекта (реализуется в наследниках)
    protected abstract T createRandomObject();

    // Общий метод для заполнения списка случайными объектами
    public MyArrayList<T> createRandomInputArray(int length) {
        MyArrayList<T> items = new MyArrayList<>();
        for (int i = 0; i < length; i++) {
            items.add(createRandomObject());
        }
        return items;
    }
}



