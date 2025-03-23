package search;

public class Key<T> {
    private final T value;

    public Key(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Key{value=" + value + "}";
    }
}