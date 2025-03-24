package io;

import CustomList.MyArrayList;
import data.Car;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

public class CarInputHandler extends AbstractInputHandler<Car> {
    @Override
    protected MyArrayList<Car> manualInput(int length) {
        return ManualDataInput.manualCarDataInput(length);
    }

    @Override
    protected MyArrayList<Car> randomInput(int length) {
        return RandomDataInput.createCarRandomInputArray(length);
    }

    @Override
    protected MyArrayList<Car> fileInput(String filePath) throws IOException {
        return FileReaderDataInput.readCarsFromFile(filePath);
    }

    @Override
    protected Key<Car> createKey() {
        return KeyInput.createCarKey();
    }
}