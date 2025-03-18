package data;

import java.io.Serial;
import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String author;
    private String title;
    private int pageCount;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pageCount = builder.pageCount;
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
