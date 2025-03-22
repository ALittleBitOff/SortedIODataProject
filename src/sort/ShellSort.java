package sort;

import CustomList.MyArrayList;

public class ShellSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(MyArrayList<T> list) {
        int n = list.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = list.get(i);
                int j;
                for (j = i; j >= gap && list.get(j - gap).compareTo(temp) > 0; j -= gap) {
                    list.set(j, list.get(j - gap));  // Перемещаем элемент
                }
                list.set(j, temp); // Вставляем временный элемент
            }
        }
    }
}

/* Пример использования

public class Main {
    public static void main(String[] args) {
        // Создайте новый список
        MyArrayList<Integer> list = new MyArrayList<>();

        // Добавьте элементы в список
        list.add(34);
        list.add(7);
        list.add(23);
        list.add(32);
        list.add(5);
        list.add(62);

        // Выводим оригинальный список
        System.out.println("Оригинальный список: ");
        printList(list);

        // Создаем экземпляр сортировщика
        ShellSort<Integer> shellSort = new ShellSort<>();

        // Сортируем список
        shellSort.sort(list);

        // Выводим отсортированный список
        System.out.println("Отсортированный список: ");
        printList(list);
    }

    // Метод для вывода списка в консоль
    private static void printList(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); // Переход на новую строку
    }
}
*/