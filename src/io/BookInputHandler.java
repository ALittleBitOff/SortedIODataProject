package io;

import data.Book;
import io.manualInput.ManualBookInput;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomBookInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileBookInput;
import io.textInput.FileReaderDataInput;
import CustomList.MyArrayList;
import search.BookKeyInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

/**
 * Класс для обработки ввода данных о книгах, реализует абстрактный класс {@link AbstractInputHandler}.
 * Данный класс предоставляет методы для ввода данных о книгах из разных источников:
 * <br> - вручную
 * <br> - случайным образом
 * <br> - из файла.
 * <br>
 * Также он выполняет создание ключа для поиска книги.
 */
public class BookInputHandler extends AbstractInputHandler<Book> {

    /**
     * Реализация метода для ввода данных о книгах вручную.
     *
     * @param length Количество книг для ввода.
     * @return Список книг, введенных вручную.
     */
    @Override
    protected MyArrayList<Book> manualInput(int length) {
        ManualDataInput<Book> bookInput = new ManualBookInput();
        return bookInput.manualDataInputArray(length);
    }

    /**
     * Реализация метода для создания случайных данных о книгах.
     *
     * @param length Количество случайных книг для создания.
     * @return Список случайных книг.
     */
    @Override
    protected MyArrayList<Book> randomInput(int length) {
        RandomDataInput<Book> bookInput = new RandomBookInput();
        return bookInput.createRandomInputArray(length);
    }

    /**
     * Реализация метода для чтения данных о книгах из файла.
     *
     * @param filePath Путь к файлу, из которого нужно считать данные.
     * @return Список книг, считанных из файла.
     * @throws IOException Если произошла ошибка при чтении файла.
     */
    @Override
    protected MyArrayList<Book> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Book> bookInput = new FileBookInput();
        return bookInput.readFromFile(filePath);
    }

    /**
     * Реализация метода для создания ключа поиска для книг.
     *
     * @return Ключ для поиска книги.
     */
    @Override
    protected Key<Book> createKey() {
        KeyInput<Book> carKeyInput = new BookKeyInput();
        return carKeyInput.createKey();
    }
}
