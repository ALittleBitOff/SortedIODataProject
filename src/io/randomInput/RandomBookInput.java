package io.randomInput;

import data.Book;

/**
 * Класс для случайного генератора данных о книгах.
 * <br>
 * Наследует абстрактный класс {@link RandomDataInput}, предоставляя реализацию метода
 * {@link RandomDataInput#createRandomObject()} для создания объекта типа {@link Book}.
 */
public class RandomBookInput extends RandomDataInput<Book> {

    /** Массив возможных авторов для случайного выбора. */
    private static final String[] AUTHORS = {
            "George Orwell",
            "J.K. Rowling",
            "J.R.R. Tolkien",
            "Leo Tolstoy"
    };

    /** Массив возможных названий книг для случайного выбора. */
    private static final String[] TITLES = {
            "1984",
            "Harry Potter",
            "The Lord of the Rings",
            "War and Peace"
    };

    /**
     * Метод для случайного создания объекта типа {@link Book}.
     * <br>
     * Генерирует случайные данные о книге, выбирая автора, название и количество страниц.
     * <br>
     * Количество страниц генерируется случайным образом в пределах от 50 до 2050.
     *
     * @return Созданный объект {@link Book}, собранный с помощью {@link Book.Builder}.
     */
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
