package search;

import CustomList.MyArrayList;

public class BinarySearch<T extends Comparable<T>> implements Searchable<T> {
    @Override
    public int binarySearch(MyArrayList<T> list, T key) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).compareTo(key) == 0) {
                return mid;
            } else if (list.get(mid).compareTo(key) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
/*
Пример использования

public class BinarySearchTest {
    public static void main(String[] args) {
        // Создание экземпляра BinarySearch
        BinarySearch<Integer> binarySearch = new BinarySearch<>();

        // Создание и сортировка массива
        Integer[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

        // Элемент для поиска
        Integer key = 11;

        // Выполнение бинарного поиска
        int index = binarySearch.binarySearch(sortedArray, key);

        // Вывод результата
        if (index != -1) {
            System.out.println("Элемент " + key + " найден по индексу: " + index);
        } else {
            System.out.println("Элемент " + key + " не найден в массиве.");
        }

        // Попробуем найти элемент, которого нет в массиве
        key = 4;
        index = binarySearch.binarySearch(sortedArray, key);

        if (index != -1) {
            System.out.println("Элемент " + key + " найден по индексу: " + index);
        } else {
            System.out.println("Элемент " + key + " не найден в массиве.");
        }
    }
}
*/