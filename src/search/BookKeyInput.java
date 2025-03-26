package search;

import data.Book;

/**
 * Класс для создания ключа поиска для объекта типа {@link Book}.
 * <br>
 * Этот класс получает данные для создания ключа (автор, название, количество страниц)
 * с помощью ввода пользователя.
 */
public class BookKeyInput extends KeyInput<Book> {

    /**
     * Метод для создания ключа поиска для книги.
     * <br>
     * Запрашивает у пользователя данные (автора, название, количество страниц),
     * а затем создает объект типа {@link Key} с этим ключом.
     *
     * @return Ключ, созданный для книги, содержащий автор, название и количество страниц.
     */
    @Override
    public Key<Book> createKey() {
        // Запрашиваем у пользователя информацию о книге
        String author = getStringInput("Введите автора книги (String): ");
        String title = getStringInput("Введите название книги (String): ");
        int pages = getIntInput("Введите количество страниц (int): ");

        // Создаем и возвращаем новый ключ с помощью Builder
        return new Key<>(new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pages)
                .build());
    }
}
