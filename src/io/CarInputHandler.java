package io;

import CustomList.MyArrayList;
import data.Car;
import io.manualInput.ManualCarInput;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomCarInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileCarInput;
import io.textInput.FileReaderDataInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class CarInputHandler extends AbstractInputHandler<Car> {
    @Override
    protected MyArrayList<Car> manualInput(int length) {
        ManualDataInput<Car> carInput = new ManualCarInput();
        return carInput.manualDataInputArray(length);
    }

    @Override
    protected MyArrayList<Car> randomInput(int length) {
        RandomDataInput<Car> carInput = new RandomCarInput();
        return carInput.createRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Car> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Car> carInput = new FileCarInput();
        return carInput.readFromFile(filePath);
    }

    @Override
    protected Key<Car> createKey() {
        return KeyInput.createCarKey();
    }
}