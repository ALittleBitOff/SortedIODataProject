package CustomList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void insert(int index, T item) {
        validateIndex(index); // Вы можете убрать этот вызов, если хотите добавить в конец
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public T set(int index, T item) {
        validateIndex(index); // Проверяем, валидный ли индекс
        T oldValue = (T) elements[index]; // Сохраняем старое значение для возврата
        elements[index] = item; // Заменяем элемент на новый
        return oldValue; // Возвращаем старое значение
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    @Override
    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за пределы массива.");
        }
    }

    // Метод для копирования списка
    public MyArrayList<T> copy() {
        MyArrayList<T> newList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            newList.add((T) elements[i]);
        }
        return newList;
    }

    // Метод для вывода списка
    public void toPrint() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i].toString()); // Вывод текущего элемента
        }
        System.out.println(); // Переход на новую строку после вывода всех элементов
    }
}
