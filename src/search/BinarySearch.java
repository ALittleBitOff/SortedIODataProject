package search;

import CustomList.MyArrayList;

/**
 * Класс для выполнения бинарного поиска в отсортированном списке.
 *
 * @param <T> Тип элементов списка, должен быть сравнимым (реализующий интерфейс Comparable).
 */
public class BinarySearch<T extends Comparable<T>> {

    /**
     * Метод для выполнения бинарного поиска на отсортированном списке.
     *
     * @param list Список, в котором выполняется поиск. Список должен быть отсортирован.
     * @param key  Ключ, который ищется в списке.
     * @return Индекс найденного элемента или -1, если элемент не найден.
     * @throws IllegalArgumentException если список или ключ равны null, или если список не отсортирован.
     */
    public int binarySearch(MyArrayList<T> list, T key) {
        int left = 0;  // Начало списка
        int right = list.size() - 1;  // Конец списка

        // Проверка на null значения для списка и ключа
        if (list == null || key == null) {
            throw new IllegalArgumentException("Список или ключ не могут быть null.");
        }

        // Проверка на отсортированность списка
        if (!isSorted(list)) {
            throw new IllegalArgumentException("Список должен быть отсортирован.");
        }

        // Пока левая граница меньше или равна правой, продолжаем искать
        while (left <= right) {
            // Находим середину списка
            int mid = left + (right - left) / 2;

            // Сравниваем элемент в середине с ключом
            if (list.get(mid).compareTo(key) == 0) {
                // Если элемент в середине равен ключу, возвращаем его индекс
                return mid;
            } else if (list.get(mid).compareTo(key) < 0) {
                // Если элемент в середине меньше ключа, ищем в правой части
                left = mid + 1;
            } else {
                // Если элемент в середине больше ключа, ищем в левой части
                right = mid - 1;
            }
        }
        // Если элемент не найден, возвращаем -1
        return -1;
    }

    /**
     * Проверяет, отсортирован ли список по возрастанию.
     *
     * @param list Список, который нужно проверить.
     * @return true, если список отсортирован по возрастанию, иначе false.
     */
    private boolean isSorted(MyArrayList<T> list) {
        // Проходим по списку и проверяем, что каждый элемент меньше или равен следующему
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false; // Список не отсортирован
            }
        }
        return true; // Список отсортирован
    }
}
