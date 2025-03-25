package io.randomInput;

import data.Book;

public class RandomBookInput extends RandomDataInput<Book> {

    private static final String[] AUTHORS = {
            "George Orwell",
            "J.K. Rowling",
            "J.R.R. Tolkien",
            "Leo Tolstoy"
    };
    private static final String[] TITLES = {
            "1984",
            "Harry Potter",
            "The Lord of the Rings",
            "War and Peace"
    };

    @Override
    protected Book createRandomObject() {
        String author = AUTHORS[random.nextInt(AUTHORS.length)];
        String title = TITLES[random.nextInt(TITLES.length)];
        int pageCount = random.nextInt(2000) + 50; // Минимум 50 страниц

        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pageCount)
                .build();
    }
}
