package io.manualInput;

import data.Book;

/**
 * Класс для ручного ввода данных о книге.
 * <br>
 * Наследует абстрактный класс {@link ManualDataInput}, предоставляя реализацию метода
 * {@link ManualDataInput#createObject()} для создания объекта типа {@link Book}.
 */
public class ManualBookInput extends ManualDataInput<Book> {

    /**
     * Метод для создания объекта типа {@link Book} на основе ввода данных пользователем.
     * <br>
     * Вводятся данные о книге: автор, название и количество страниц.
     *
     * @return Созданный объект {@link Book}, собранный с помощью {@link Book.Builder}.
     */
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
