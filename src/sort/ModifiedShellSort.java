package sort;

import CustomList.MyArrayList;

/**
 * Модифицированная реализация сортировки методом Шелла.
 * <br>
 * Сортируются только элементы с четными значениями числового поля,
 * а элементы с нечетными значениями остаются на своих местах.
 *
 * @param <T> Тип элементов списка, должен реализовывать {@link Comparable}.
 */
public class ModifiedShellSort<T extends Comparable<T>> implements SortStrategy<T> {

    /**
     * Выполняет сортировку методом Шелла только для элементов с четными значениями.
     * <br>
     * Элементы с нечетными значениями остаются на своих местах.
     *
     * @param list Список элементов, который будет отсортирован.
     */
    @Override
    public void sort(MyArrayList<T> list) {
        int n = list.size();

        // Перебираем интервалы (gap), начиная с половины длины списка
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Проходим по элементам списка
            for (int i = gap; i < n; i++) {
                // Пропускаем элементы с нечетными значениями
                if (!isEven(list.get(i))) {
                    continue;
                }

                T temp = list.get(i);
                int j = i;

                // Перемещаем только четные элементы
                while (j >= gap && isEven(list.get(j - gap)) && list.get(j - gap).compareTo(temp) > 0) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }

                list.set(j, temp);
            }
        }
    }

    /**
     * Метод определяет, является ли числовое значение объекта четным.
     *
     * @param item Элемент списка.
     * @return true, если элемент имеет четное числовое поле, иначе false.
     */
    private boolean isEven(T item) {
        // Предполагается, что объект переопределяет метод toString() и содержит числовое поле
        String[] parts = item.toString().split(" ");
        for (String part : parts) {
            try {
                int value = Integer.parseInt(part);
                return value % 2 == 0;
            } catch (NumberFormatException ignored) {
            }
        }
        return false;
    }
}
