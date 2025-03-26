package search;

import data.Korneplod;

/**
 * Класс для ввода данных, необходимых для создания ключа для {@link Korneplod}.
 * <br>
 * Этот класс реализует метод {@link KeyInput#createKey()}, который запрашивает у пользователя
 * ввод информации для создания ключа, связанного с объектом типа {@link Korneplod}.
 */
public class KorneplodKeyInput extends KeyInput<Korneplod> {

    /**
     * Создает ключ для {@link Korneplod}, запрашивая у пользователя необходимую информацию.
     * <br>
     * Запрашиваемые данные включают тип, массу и цвет.
     *
     * @return Новый ключ для {@link Korneplod}.
     */
    @Override
    public Key<Korneplod> createKey() {
        // Запрашиваем данные от пользователя
        String type = getStringInput("Введите тип (String): ");
        double weight = getDoubleInput("Введите массу (double): ");
        String color = getStringInput("Введите цвет (String): ");

        // Создаем объект типа Korneplod с введенными данными и возвращаем его в виде ключа
        return new Key<>(new Korneplod.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build());
    }
}
