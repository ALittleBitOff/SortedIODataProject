package sort;

public class ShellSort<T extends Comparable<T>> implements SortStrategy<T> {
    @Override
    public void sort(T[] array) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap].compareTo(temp) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
/*
Пример использования ShellSort
package sort;

public class ShellSortTest {
    public static void main(String[] args) {

        ShellSort<Integer> shellSort = new ShellSort<>(); Вот это необходимо для работы (создание экземпляра)

        Integer[] array = {5, 2, 9, 1, 5, 6};

        System.out.println("Исходный массив:");
        printArray(array);

        shellSort.sort(array);

        System.out.println("Отсортированный массив:");
        printArray(array);
    }

    private static void printArray(Integer[] array) {
        for (Integer number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
*/