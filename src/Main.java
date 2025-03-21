import io.BookInputHandler;
import io.CarInputHandler;
import io.DataInputHandler;
import io.KornepodInputHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[1] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Создаем карту для хранения обработчиков ввода
        Map<Integer, DataInputHandler> inputHandlers = new HashMap<>();
        inputHandlers.put(1, new CarInputHandler());
        inputHandlers.put(2, new BookInputHandler());
        inputHandlers.put(3, new KornepodInputHandler());

        do {
            System.out.println("Выберите тип ввода данных для сортировки:");
            System.out.println("1 - тип данных автомобиль");
            System.out.println("2 - тип данных книга");
            System.out.println("3 - тип данных корнеплод");
            System.out.println("4 - выход из программы");

            choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Выход из программы.");
                break;
            }

            DataInputHandler handler = inputHandlers.get(choice);
            if (handler != null) {
                handler.handleInput(scanner);
            } else {
                System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        } while (true);

        scanner.close();
    }
}