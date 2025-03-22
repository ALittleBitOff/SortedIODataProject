package sort;

import CustomList.MyArrayList;

public interface SortStrategy<T> {
    void sort(MyArrayList<T> list);
}
