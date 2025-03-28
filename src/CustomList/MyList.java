package CustomList;

/**
 * Интерфейс для списка, который поддерживает основные операции работы с коллекцией.
 * <br>
 * Он определяет методы для добавления, удаления, получения и вставки элементов, а также для получения размера списка и очистки списка.
 *
 * @param <T> Тип элементов в списке.
 */
public interface MyList<T> {

    /**
     * Добавляет новый элемент в конец списка.
     *
     * @param item Элемент, который нужно добавить в список.
     */
    void add(T item);

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index Индекс элемента, который нужно получить.
     * @return Элемент, находящийся по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    T get(int index);

    /**
     * Вставляет новый элемент в список по указанному индексу.
     * <br>
     * Все элементы после индекса сдвигаются вправо.
     *
     * @param index Индекс, по которому нужно вставить элемент.
     * @param item Элемент, который нужно вставить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    void insert(int index, T item);

    /**
     * Заменяет элемент в списке по указанному индексу.
     * <br>
     * Возвращает старое значение элемента, который был заменен.
     *
     * @param index Индекс элемента, который нужно заменить.
     * @param item Новый элемент, который заменит старый.
     * @return Старое значение элемента, который был заменен.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    T set(int index, T item);

    /**
     * Удаляет элемент по указанному индексу.
     * <br>
     * Все элементы после индекса сдвигаются влево.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс выходит за пределы текущего списка.
     */
    void remove(int index);

    /**
     * Возвращает количество элементов в списке.
     *
     * @return Количество элементов в списке.
     */
    int size();

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, иначе false.
     */
    boolean isEmpty();

    /**
     * Очищает список, удаляя все элементы.
     */
    void clear();
}
