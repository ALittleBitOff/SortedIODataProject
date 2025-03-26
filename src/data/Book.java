package data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

/**
 * Класс, представляющий книгу с автором, названием и количеством страниц.
 * <br>
 * Реализует интерфейсы {@link Comparable} для сортировки и {@link Serializable} для возможности сериализации.
 */
public class Book implements Comparable<Book>, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String author;
    private final String title;
    private final int pageCount;

    /**
     * Приватный конструктор книги, принимающий {@link Builder} для создания объекта книги.
     *
     * @param builder Строитель, содержащий параметры для книги.
     */
    private Book(Builder builder) {
        this.author = validateAuthor(builder.author);
        this.title = validateTitle(builder.title);
        this.pageCount = validatePages(builder.pageCount);
    }

    /**
     * Валидация имени автора.
     * <br>
     * Проверяет, что имя не пустое, не null, и соответствует регулярному выражению.
     *
     * @param author Имя автора книги.
     * @return Валидированное имя автора.
     * @throws IllegalArgumentException Если имя пустое, null или не соответствует регулярному выражению.
     */
    private String validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя автора не может быть пустым или null");
        }
        if (!author.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Имя автора не соответствует регулярному выражению");
        }
        return author.trim();
    }

    /**
     * Валидация названия книги.
     * <br>
     * Проверяет, что название не пустое, не null, и соответствует регулярному выражению.
     *
     * @param title Название книги.
     * @return Валидированное название книги.
     * @throws IllegalArgumentException Если название пустое, null или не соответствует регулярному выражению.
     */
    private String validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название книги не может быть пустым или null");
        }
        if (!title.matches("[a-zA-Zа-яА-Я0-9\\s\\-'’,.!?]+")) {
            throw new IllegalArgumentException("Название книги не соответствует регулярному выражению");
        }
        return title.trim();
    }

    /**
     * Валидация количества страниц.
     * <br>
     * Проверяет, что количество страниц больше нуля.
     *
     * @param pages Количество страниц в книге.
     * @return Валидированное количество страниц.
     * @throws IllegalArgumentException Если количество страниц меньше или равно нулю.
     */
    private int validatePages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Количество страниц должно быть положительным");
        }
        return pages;
    }

    /**
     * Строитель для создания экземпляров книги.
     */
    public static class Builder {
        private String author;
        private String title;
        private int pageCount;

        /**
         * Устанавливает автора книги.
         *
         * @param author Автор книги.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        /**
         * Устанавливает название книги.
         *
         * @param title Название книги.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Устанавливает количество страниц книги.
         *
         * @param pageCount Количество страниц книги.
         * @return {@link Builder} для цепочечного вызова.
         */
        public Builder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        /**
         * Строит экземпляр книги с указанными параметрами.
         *
         * @return Новый объект {@link Book}.
         */
        public Book build() {
            return new Book(this);
        }
    }

    /**
     * Сравнивает текущую книгу с другой книгой.
     * <br>
     * Сначала сравнивается автор, затем название, и, если необходимо, количество страниц.
     *
     * @param otherBook Другая книга для сравнения.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(Book otherBook) {
        return Comparator.comparing(Book::getAuthor)
                .thenComparing(Book::getTitle)
                .thenComparing(Book::getPageCount)
                .compare(this, otherBook);
    }

    /**
     * Получает автора книги.
     *
     * @return Автор книги.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Получает название книги.
     *
     * @return Название книги.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Получает количество страниц книги.
     *
     * @return Количество страниц.
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Возвращает строковое представление книги.
     *
     * @return Строковое представление книги.
     */
    @Override
    public String toString() {
        return String.format("Книга { Автор: %s, Название: %s, Количество страниц: %s }", author, title, pageCount);
    }
}
