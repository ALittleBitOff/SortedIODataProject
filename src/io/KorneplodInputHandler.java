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
import search.KorneplodKeyInput;
import java.io.IOException;

/**
 * Класс для обработки ввода данных о корнеплодах, реализует абстрактный класс {@link AbstractInputHandler}.
 * Этот класс предоставляет методы для ввода данных о корнеплодах из различных источников:
 * <br> - вручную,
 * <br> - случайным образом,
 * <br> - из файла.
 * <br>
 * Также он предоставляет функциональность для создания ключа поиска корнеплода.
 */
public class KorneplodInputHandler extends AbstractInputHandler<Korneplod> {

    /**
     * Реализация метода для ввода данных о корнеплодах вручную.
     *
     * @param length Количество корнеплодов для ввода.
     * @return Список корнеплодов, введенных вручную.
     */
    @Override
    protected MyArrayList<Korneplod> manualInput(int length) {
        ManualDataInput<Korneplod> korneplodInput = new ManualKorneplodInput();
        return korneplodInput.manualDataInputArray(length);
    }

    /**
     * Реализация метода для генерации случайных данных о корнеплодах.
     *
     * @param length Количество случайных корнеплодов для создания.
     * @return Список случайных корнеплодов.
     */
    @Override
    protected MyArrayList<Korneplod> randomInput(int length) {
        RandomDataInput<Korneplod> korneplodInput = new RandomKorneplodInput();
        return korneplodInput.createRandomInputArray(length);
    }

    /**
     * Реализация метода для чтения данных о корнеплодах из файла.
     *
     * @param filePath Путь к файлу, из которого нужно считать данные.
     * @return Список корнеплодов, считанных из файла.
     * @throws IOException Если произошла ошибка при чтении файла.
     */
    @Override
    protected MyArrayList<Korneplod> fileInput(String filePath) throws IOException {
        FileReaderDataInput<Korneplod> korneplodInput = new FileKorneplodInput();
        return korneplodInput.readFromFile(filePath);
    }

    /**
     * Реализация метода для создания ключа поиска для корнеплодов.
     *
     * @return Ключ для поиска корнеплода.
     */
    @Override
    protected Key<Korneplod> createKey() {
        KeyInput<Korneplod> korneplodKeyInput = new KorneplodKeyInput();
        return korneplodKeyInput.createKey();
    }
}
