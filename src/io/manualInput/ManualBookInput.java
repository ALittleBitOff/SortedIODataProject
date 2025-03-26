package io.manualInput;

import data.Book;

public class ManualBookInput extends ManualDataInput<Book> {

    @Override
    protected Book createObject() {
        System.out.println("Введите автора книги (String): ");
        String author = scanner.nextLine();

        System.out.println("Введите название книги (String): ");
        String title = scanner.nextLine();

        System.out.println("Введите количество страниц (int): ");
        int pages = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pages)
                .build();
    }
}
