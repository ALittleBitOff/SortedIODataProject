package CustomList;

public interface MyList<T> {
    void add(T item);

    T get(int index);

    void insert(int index, T item);

    T set(int index, T item);

    void remove(int index);

    int size();

    boolean isEmpty();

    void clear();
}
