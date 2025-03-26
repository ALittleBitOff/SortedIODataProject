package io;

import CustomList.MyArrayList;
import data.Car;
import io.manualInput.ManualCarInput;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomCarInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileCarInput;
import io.textInput.FileReaderDataInput;
import search.CarKeyInput;
import search.Key;
import search.KeyInput;
import java.io.IOException;

/**
 * Класс для обработки ввода данных о автомобилях, реализует абстрактный класс {@link AbstractInputHandler}.
 * Этот класс предоставляет методы для ввода данных о машинах из различных источников:
 * <br> - вручную,
 * <br> - случайным образом,
 * <br> - из файла.
 * <br>
 * Также он предоставляет функциональность для создания ключа поиска автомобиля.
 */
public class CarInputHandler extends AbstractInputHandler<Car> {

    /**
     * Реализация метода для ввода данных о автомобилях вручную.
     *
     * @param length Количество автомобилей для ввода.
     * @return Список автомобилей, введенных вручную.
     */
    @Override
    protected MyArrayList<Car> manualInput(int length) {
        ManualDataInput<Car> carInput = new ManualCarInput();
        return carInput.manualDataInputArray(length);
    }

    /**
     * Реализация метода для генерации случайных данных о автомобилях.
     *
     * @param length Количество случайных автомобилей для создания.
     * @return Список случайных автомобилей.
     */
    @Override
    protected MyArrayList<Car> randomInput(int length) {
        RandomDataInput<Car> carInput = new RandomCarInput();
        return carInput.createRandomInputArray(length);
    }

    /**
     * Реализация метода для чтения данных о автомобилях из файла.
     *
     * @param filePath Путь к файлу, из которого нужно считать данные.
     * @return Список автомобилей, считанных из файла.
     * @throws IOException Если произошла ошибка при чтении файла.
     */
    @Override
    protected MyArrayList<Car> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Car> carInput = new FileCarInput();
        return carInput.readFromFile(filePath);
    }

    /**
     * Реализация метода для создания ключа поиска для автомобилей.
     *
     * @return Ключ для поиска автомобиля.
     */
    @Override
    protected Key<Car> createKey() {
        KeyInput<Car> carKeyInput = new CarKeyInput();
        return carKeyInput.createKey();
    }
}
