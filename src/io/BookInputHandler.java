package io;

import data.Book;
import io.manualInput.ManualBookInput;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomBookInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileBookInput;
import io.textInput.FileReaderDataInput;
import CustomList.MyArrayList;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class BookInputHandler extends AbstractInputHandler<Book> {
    @Override
    protected MyArrayList<Book> manualInput(int length) {
        ManualDataInput<Book> bookInput = new ManualBookInput();
        return bookInput.manualDataInputArray(length);
    }

    @Override
    protected MyArrayList<Book> randomInput(int length) {
        RandomDataInput<Book> bookInput = new RandomBookInput();
        return bookInput.createRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Book> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Book> bookInput = new FileBookInput();
        return bookInput.readFromFile(filePath);
    }

    @Override
    protected Key<Book> createKey() {
        return KeyInput.createBookKey();
    }
}
