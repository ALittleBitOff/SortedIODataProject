package sort;

import CustomList.MyArrayList;

/**
 * Интерфейс стратегии сортировки.
 * <br>
 * Этот интерфейс определяет общий метод для сортировки списка с использованием различных алгоритмов сортировки.
 *
 * @param <T> Тип элементов списка, должен быть сравнимым (реализующий интерфейс {@link Comparable}).
 */
public interface SortStrategy<T> {

    /**
     * Метод сортировки списка.
     * <br>
     * Классы, реализующие этот интерфейс, должны предоставить свою реализацию метода сортировки,
     * используя выбранный алгоритм сортировки.
     *
     * @param list Список, который необходимо отсортировать.
     */
    void sort(MyArrayList<T> list);
}
