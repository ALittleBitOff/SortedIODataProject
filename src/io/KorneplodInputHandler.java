package io;

import CustomList.MyArrayList;
import data.Korneplod;
import io.manualInput.ManualDataInput;
import io.manualInput.ManualKorneplodInput;
import io.randomInput.RandomDataInput;
import io.randomInput.RandomKorneplodInput;
import io.textInput.FileKorneplodInput;
import io.textInput.FileReaderDataInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class KorneplodInputHandler extends AbstractInputHandler<Korneplod> {
    @Override
    protected MyArrayList<Korneplod> manualInput(int length) {
        ManualDataInput<Korneplod> korneplodInput = new ManualKorneplodInput();
        return korneplodInput.manualDataInputArray(length);
    }

    @Override
    protected MyArrayList<Korneplod> randomInput(int length) {
        RandomDataInput<Korneplod> korneplodInput = new RandomKorneplodInput();
        return korneplodInput.createRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Korneplod> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Korneplod> korneplodInput = new FileKorneplodInput();
        return korneplodInput.readFromFile(filePath);
    }

    @Override
    protected Key<Korneplod> createKey() {
        return KeyInput.createKornepodKey();
    }
}