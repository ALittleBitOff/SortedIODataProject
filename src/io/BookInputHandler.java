package io;

import data.Book;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import CustomList.MyArrayList;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class BookInputHandler extends AbstractInputHandler<Book> {
    @Override
    protected MyArrayList<Book> manualInput(int length) {
        return ManualDataInput.manualBookDataInput(length);
    }

    @Override
    protected MyArrayList<Book> randomInput(int length) {
        return RandomDataInput.createBookRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Book> fileInput(String filePath) throws IOException {
        return FileReaderDataInput.readBookFromFile(filePath);
    }

    @Override
    protected Key<Book> createKey() {
        return KeyInput.createBookKey();
    }
}
