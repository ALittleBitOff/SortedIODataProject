package search;

/**
 * Класс для представления ключа поиска.
 * <br>
 * Этот класс используется для обертки значений, которые могут быть использованы в поисковых операциях.
 *
 * @param <T> Тип значения, которое будет храниться в ключе. Это значение должно быть сравнимым
 *            (реализовать интерфейс {@link Comparable}), чтобы его можно было использовать в поиске.
 */
public class Key<T> {
    private final T value;

    /**
     * Конструктор для создания нового ключа с заданным значением.
     *
     * @param value Значение ключа.
     */
    public Key(T value) {
        this.value = value;
    }

    /**
     * Метод для получения значения ключа.
     *
     * @return Значение, которое хранится в ключе.
     */
    public T getValue() {
        return value;
    }

    /**
     * Переопределение метода {@link Object#toString()} для предоставления строкового
     * представления ключа.
     *
     * @return Строковое представление ключа, включающее его значение.
     */
    @Override
    public String toString() {
        return "Key{value=" + value + "}";
    }
}
