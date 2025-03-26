package search;

import data.Book;

public class BookKeyInput extends KeyInput<Book> {
    @Override
    public Key<Book> createKey() {
        String author = getStringInput("Введите автора книги (String): ");
        String title = getStringInput("Введите название книги (String): ");
        int pages = getIntInput("Введите количество страниц (int): ");

        return new Key<>(new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pages)
                .build());
    }
}