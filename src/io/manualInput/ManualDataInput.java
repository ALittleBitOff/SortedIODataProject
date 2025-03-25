package io.manualInput;

import CustomList.MyArrayList;

import java.util.Scanner;

public abstract class ManualDataInput<T> {
    protected static final Scanner scanner = new Scanner(System.in);

    protected abstract T createObject();

    public MyArrayList<T> manualDataInputArray(int length) {
        MyArrayList<T> items = new MyArrayList<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Элемент номер: " + i);
            items.add(createObject()); // Вызываем реализацию из наследника
        }
        return items;
    }
}

