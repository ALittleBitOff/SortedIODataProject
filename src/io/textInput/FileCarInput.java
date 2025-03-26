package io.textInput;

import data.Car;

/**
 * Класс для чтения данных о машинах из текстового файла.
 * <br>
 * Этот класс наследует {@link FileReaderDataInput} и реализует метод
 * {@link FileReaderDataInput#parseLine(String[])} для парсинга строк файла
 * и создания объектов типа {@link Car}.
 * <br>
 * Каждая строка файла должна содержать информацию о машине в формате:
 * мощность, модель, год выпуска, разделенные запятой или другим разделителем.
 */
public class FileCarInput extends FileReaderDataInput<Car> {

    /**
     * Парсинг строки, содержащей данные о машине.
     * <br>
     * Строка должна содержать мощность, модель и год выпуска автомобиля.
     * <br>
     * Метод выделяет каждую часть строки и преобразует её в соответствующие типы.
     *
     * @param parts Массив строк, представляющих части данных о машине.
     *              Ожидается, что первый элемент - это мощность, второй - модель,
     *              а третий - год выпуска.
     * @return Созданный объект {@link Car}.
     * @throws NumberFormatException Если первая или третья часть строки (мощность или год выпуска)
     *                                не могут быть преобразованы в целое число.
     */
    @Override
    protected Car parseLine(String[] parts) throws NumberFormatException {
        int power = Integer.parseInt(parts[0].trim());
        String model = parts[1].trim();
        int year = Integer.parseInt(parts[2].trim());
        return new Car.Builder()
                .setHorsePower(power)
                .setModel(model)
                .setReleaseYear(year)
                .build();
    }
}
