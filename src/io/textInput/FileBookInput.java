package io.textInput;

import data.Book;

/**
 * Класс для чтения данных о книгах из текстового файла.
 * <br>
 * Этот класс наследует {@link FileReaderDataInput} и реализует метод
 * {@link FileReaderDataInput#parseLine(String[])} для парсинга строк файла
 * и создания объектов типа {@link Book}.
 * <br>
 * Каждая строка файла должна содержать информацию о книге в формате:
 * автор, название, количество страниц, разделенные запятой или другим разделителем.
 */
public class FileBookInput extends FileReaderDataInput<Book> {

    /**
     * Парсинг строки, содержащей данные о книге.
     * <br> Строка должна содержать авторов, название и количество страниц книги.
     * <br> Метод выделяет каждую часть строки и преобразует её в соответствующие типы.
     *
     * @param parts Массив строк, представляющих части данных о книге.
     *              Ожидается, что первый элемент - это автор, второй - название,
     *              а третий - количество страниц.
     * @return Созданный объект {@link Book}.
     * @throws NumberFormatException Если третья часть строки (количество страниц)
     *                                не может быть преобразована в целое число.
     */
    @Override
    protected Book parseLine(String[] parts) throws NumberFormatException {
        String author = parts[0].trim();
        String title = parts[1].trim();
        int pageCount = Integer.parseInt(parts[2].trim());
        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPageCount(pageCount)
                .build();
    }
}
