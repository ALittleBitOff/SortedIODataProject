package io.textInput;

import data.Korneplod;

/**
 * Класс для чтения данных о корнеплодах из текстового файла.
 * <br>
 * Этот класс наследует {@link FileReaderDataInput} и реализует метод
 * {@link FileReaderDataInput#parseLine(String[])} для парсинга строк файла
 * и создания объектов типа {@link Korneplod}.
 * <br>
 * Каждая строка файла должна содержать информацию о корнеплоды в формате:
 * тип, масса, цвет, разделенные запятой или другим разделителем.
 */
public class FileKorneplodInput extends FileReaderDataInput<Korneplod> {

    /**
     * Парсинг строки, содержащей данные о корнеплодах.
     * <br>
     * Строка должна содержать тип, массу и цвет корнеплода.
     * <br>
     * Метод выделяет каждую часть строки и преобразует её в соответствующие типы.
     *
     * @param parts Массив строк, представляющих части данных о корнеплоде.
     *              Ожидается, что первый элемент - это тип, второй - масса,
     *              а третий - цвет.
     * @return Созданный объект {@link Korneplod}.
     * @throws NumberFormatException Если вторая часть строки (масса) не может быть
     *                                преобразована в число с плавающей точкой.
     */
    @Override
    protected Korneplod parseLine(String[] parts) throws NumberFormatException {
        String type = parts[0].trim();
        double weight = Double.parseDouble(parts[1].trim());
        String color = parts[2].trim();
        return new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }
}
