package CustomList;

import java.util.Arrays;

/**
 * Класс, реализующий динамический список на основе массива.
 * <br>
 * Этот список может хранить элементы любого типа и поддерживает основные операции работы с коллекцией, такие как добавление, удаление,
 * получение элементов по индексу, а также динамическое изменение размера массива.
 *
 * @param <T> Тип элементов в списке.
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Конструктор, создающий пустой список с начальной ёмкостью 10.
     */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Добавляет новый элемент в конец списка.
     * <br>
     * Если список заполнен, увеличивает его ёмкость.
     *
     * @param item Элемент, который нужно добавить в список.
     */
    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    /**
     * Вставляет элемент в список по заданному индексу.
     * <br>
     * Все элементы после индекса сдвигаются вправо.
     *
     * @param index Индекс, по которому нужно вставить элемент.
     * @param item Элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    @Override
    public void insert(int index, T item) {
        validateIndex(index); // Вы можете убрать этот вызов, если хотите добавить в конец
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    /**
     * Заменяет элемент в списке по заданному индексу и возвращает старое значение.
     *
     * @param index Индекс элемента, который нужно заменить.
     * @param item Новый элемент, который заменит старый.
     * @return Старое значение элемента, который был заменен.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    @Override
    public T set(int index, T item) {
        validateIndex(index); // Проверяем, валидный ли индекс
        T oldValue = (T) elements[index]; // Сохраняем старое значение для возврата
        elements[index] = item; // Заменяем элемент на новый
        return oldValue; // Возвращаем старое значение
    }

    /**
     * Получает элемент по индексу.
     *
     * @param index Индекс элемента, который нужно получить.
     * @return Элемент, находящийся по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по заданному индексу.
     * <br>
     * Все элементы после удаляемого сдвигаются влево.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    @Override
    public void remove(int index) {
        validateIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return Количество элементов в списке.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, иначе false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    @Override
    public void clear() {
        Arrays.fill(elements, 0, size, null);
        size = 0;
    }

    /**
     * Увеличивает ёмкость списка, если это необходимо.
     * <br>
     * Новый размер массива в два раза больше текущего.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    /**
     * Проверяет, является ли индекс валидным.
     *
     * @param index Индекс для проверки.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за пределы массива.");
        }
    }

    /**
     * Возвращает строковое представление списка.
     *
     * @return Строковое представление списка.
     */
    @Override
    public String toString() {
        StringBuilder array = new StringBuilder(getClass().getSimpleName())
                .append(" (count=").append(size).append("):\n");

        for (int i = 0; i < size; i++) {
            array.append(i + 1).append(". ").append(elements[i]).append("\n");
        }

        return array.toString();
    }

    /**
     * Создает и возвращает копию текущего списка.
     *
     * @return Новый список, содержащий те же элементы, что и текущий.
     */
    public MyArrayList<T> copy() {
        MyArrayList<T> newList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            newList.add((T) elements[i]);
        }
        return newList;
    }

    /**
     * Печатает все элементы списка на экран.
     */
    public void toPrint() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i].toString()); // Вывод текущего элемента
        }
    }
}
