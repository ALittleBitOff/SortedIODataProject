package data;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String author;
    private final String title;
    private final int pageCount;

    private Book(Builder builder) {
        this.author = validateAuthor(builder.author);
        this.title = validateTitle(builder.title);
        this.pageCount = validatePages(builder.pageCount);
    }

    // Валидация автора
    private String validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя автора не может быть пустым или null");
        }
        if (!author.matches("[a-zA-Zа-яА-Я0-9\\s.'-]+")) {
            throw new IllegalArgumentException("Имя автора не соответствует регулярному выражению");
        }
        return author.trim();
    }

    // Валидация названия
    private String validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Название книги не может быть пустым или null");
        }
        if (!title.matches("[a-zA-Zа-яА-Я0-9\\s\\-'’,.!?]+")) {
            throw new IllegalArgumentException("Название книги не соответствует регулярному выражению");
        }
        return title.trim();
    }

    // Валидация количества страниц
    private int validatePages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Количество страниц должно быть положительным");
        }
        return pages;
    }

    public static class Builder {
        private String author;
        private String title;
        private int pageCount;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPageCount(int pageCount) {
            this.pageCount = pageCount;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public int compareTo(Book otherBook) {

        // 1. Сравнение по автору
        int authorComparison = this.author.compareTo(otherBook.author);
        if (authorComparison != 0) {
            return authorComparison;
        }

        // 2. Сравнение по названию
        int titleComparison = this.title.compareTo(otherBook.title);
        if (titleComparison != 0) {
            return titleComparison;
        }

        // 3. Сравнение по количеству страниц
        return Integer.compare(this.pageCount, otherBook.pageCount);
    }

    @Override
    public String toString() {
        return "Book {" +
                "author: " + author +
                ", title: " + title +
                ", pageCount: " + pageCount +
                '}';
    }
}
