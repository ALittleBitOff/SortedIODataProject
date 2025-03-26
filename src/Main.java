import io.AbstractInputHandler;
import io.BookInputHandler;
import io.CarInputHandler;
import io.KorneplodInputHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс программы, который управляет выбором типа данных для сортировки.
 * <br>
 * Пользователь может выбрать тип данных для сортировки (автомобиль, книга, корнеплод) и способ ввода данных.
 * <br>
 * Также есть возможность выхода из программы.
 * <br>
 * Программа реализует взаимодействие с пользователем с помощью меню, где он может выбрать:
 * <br> - тип данных для сортировки,
 * <br> - способ ввода данных (вручную, случайно или из файла),
 * <br> - или выйти из программы.
 */
public class Main {

    /**
     * Основной метод программы. Позволяет пользователю выбрать тип данных для сортировки,
     * вводить данные и обрабатывать их с помощью соответствующего обработчика.
     * <br>
     * После обработки данных предлагает пользователю продолжить или выйти.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Создаем карту для хранения обработчиков ввода
        Map<Integer, AbstractInputHandler> inputHandlers = new HashMap<>();
        inputHandlers.put(1, new CarInputHandler());
        inputHandlers.put(2, new BookInputHandler());
        inputHandlers.put(3, new KorneplodInputHandler());

        do {
            // Отображение меню выбора типа данных для сортировки
            System.out.println("Выберите тип ввода данных для сортировки:");
            System.out.println("1 - тип данных автомобиль");
            System.out.println("2 - тип данных книга");
            System.out.println("3 - тип данных корнеплод");
            System.out.println("4 - выход из программы");

            // Получаем выбор пользователя
            choice = scanner.nextInt();

            // Если выбор пользователя - выход, завершаем программу
            if (choice == 4) {
                System.out.println("Выход из программы.");
                break;
            }

            // Получаем обработчик для выбранного типа данных и вызываем метод для обработки ввода
            AbstractInputHandler handler = inputHandlers.get(choice);
            if (handler != null) {
                handler.handleInput(scanner);
            } else {
                // Если был сделан неверный выбор, выводим сообщение
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }

            // Предложение продолжить или выйти
            System.out.println("Хотите продолжить? (1 - Да, 2 - Нет)");
            int continueChoice = scanner.nextInt();
            if (continueChoice == 2) {
                System.out.println("Выход из программы.");
                break;
            }
        } while (true);

        // Закрытие сканера
        scanner.close();
    }
}
