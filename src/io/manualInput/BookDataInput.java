package io.manualInput;

import data.Book;
import CustomList.MyArrayList;
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

    public static MyArrayList<Book> createBookArrayFromConsole(int length) {

        MyArrayList<Book> myBookList = new MyArrayList<>();
//        ShellSort<Book> shellBookSort = new ShellSort<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Введите количество книг " + (i + 1) + ":");
             myBookList.add(createBookFromConsole());
        }

//        shellBookSort.sort(myBookList);

        return myBookList;
    }
}