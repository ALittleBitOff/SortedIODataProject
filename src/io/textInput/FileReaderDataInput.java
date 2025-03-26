package io.textInput;

import CustomList.MyArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Абстрактный класс для чтения данных из файла и преобразования их в объекты.
 * <br>
 * Этот класс читает строки из файла и передает их в метод {@link #parseLine(String[])}
 * для преобразования в объект типа {@link T}. Реализация этого метода
 * должна быть предоставлена подклассами.
 * <br>
 * Класс работает с текстовыми файлами, где данные разделены запятыми.
 * <br>
 * В случае ошибки при обработке строки, выводится сообщение об ошибке.
 *
 * @param <T> Тип объектов, которые будут созданы из строк файла.
 */
public abstract class FileReaderDataInput<T> {

    /**
     * Метод для парсинга строки данных и преобразования их в объект типа {@link T}.
     * <br>
     * Этот метод должен быть реализован в наследующих классах.
     *
     * @param parts Массив строк, представляющий данные из одной строки файла.
     * @return Объект типа {@link T}, полученный из данных.
     * @throws NumberFormatException Если данные не могут быть преобразованы в нужный формат.
     */
    protected abstract T parseLine(String[] parts) throws NumberFormatException;

    /**
     * Чтение данных из файла и преобразование их в список объектов типа {@link T}.
     * <br>
     * Каждая строка в файле должна представлять собой набор данных, разделенный запятой.
     * <br>
     * Ошибки при обработке строки (например, неправильный формат данных) будут
     * выводиться в консоль.
     *
     * @param filePath Путь к файлу, из которого будут читать данные.
     * @return Список объектов типа {@link T}, прочитанных из файла.
     * @throws IOException Если возникла ошибка при чтении файла.
     */
    public MyArrayList<T> readFromFile(String filePath) throws IOException {
        MyArrayList<T> items = new MyArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;  // Пропускаем пустые строки
                }
                String[] parts = line.split(",");  // Разделяем строку по запятой
                try {
                    T item = parseLine(parts);  // Преобразуем строку в объект
                    items.add(item);
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка обработки строки: " + line + ". Причина: " + e.getMessage());
                }
            }
        }
        return items;
    }
}
