package io.manualInput;

import data.Book;

import java.util.Scanner;

public class BookDataInput {

    public static Book createBookFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите автора книги (String): ");
        String author = scanner.nextLine();

        System.out.print("Введите название книги (String): ");
        String title = scanner.nextLine();

        System.out.print("Введите количество страниц (int): ");
        int pages = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pages)
                .build();
    }
    public static Book[] createBookArrayFromConsole(int length) {
        Book[] books = new Book[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Введите количество книг " + (i + 1) + ":");
             books[i] = createBookFromConsole();
        }
        return books;
    }
}