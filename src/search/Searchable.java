package search;

import CustomList.MyArrayList;

public interface Searchable<T> {
    int binarySearch(MyArrayList<T> list, T key);
}
