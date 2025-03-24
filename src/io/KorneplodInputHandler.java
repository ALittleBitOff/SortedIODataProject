package io;

import CustomList.MyArrayList;
import data.Korneplod;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class KorneplodInputHandler extends AbstractInputHandler<Korneplod> {
    @Override
    protected MyArrayList<Korneplod> manualInput(int length) {
        return ManualDataInput.manualKorneplodDataInput(length);
    }

    @Override
    protected MyArrayList<Korneplod> randomInput(int length) {
        return RandomDataInput.createKorneplodRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Korneplod> fileInput(String filePath) throws IOException {
        return FileReaderDataInput.readKorneplodFromFile(filePath);
    }

    @Override
    protected Key<Korneplod> createKey() {
        return KeyInput.createKornepodKey();
    }
}