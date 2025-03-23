import io.BookInputHandler;
import io.CarInputHandler;
import io.DataInputHandler;
import io.KornepodInputHandler;
import io.Vyvod;

import java.awt.print.Book;
import java.io.IOException;
import java.util.*;

import static io.vyvodVfile.Vyvod.sortAndSave;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Sortable> items = new ArrayList<>();
        String filename = "data.txt";
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

            // Предложение выйти или продолжить
            System.out.println("Хотите продолжить? (1 - Да, 2 - Нет)");
            int continueChoice = scanner.nextInt();
            if (continueChoice == 2) {
                System.out.println("Выход из программы.");
                break;
            }
            //Запись отсортированных коллекций/найденных значений в файл в режиме добавления данных
        } while (true) {

            System.out.println("Выберите действие: 1 - Добавить Car, 2 - Добавить Book, 3 - Добавить Korneplod, 4 - Вывести данные, 5 - Сохранить, 0 - Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.print("Введите мощность машины: ");
                    int power = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера
                    System.out.print("Введите модель машины: ");
                    String model = scanner.nextLine();
                    System.out.print("Введите год выпуска: ");
                    int year = scanner.nextInt();
                    items.add(new Car(power, model, year));
                    break;
                case 2:
                    System.out.print("Введите автора книги: ");
                    String author = scanner.nextLine();
                    System.out.print("Введите название книги: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите количество страниц: ");
                    int pages = scanner.nextInt();
                    items.add(new Book(author, title, pages));
                    break;
                case 3:
                    System.out.print("Введите тип корнеплода: ");
                    String type = scanner.nextLine();
                    System.out.print("Введите вес корнеплода: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // очистка буфера
                    System.out.print("Введите цвет корнеплода: ");
                    String color = scanner.nextLine();
                    items.add(new Korneplod(type, weight, color));
                    break;
                case 4:
                    System.out.println("Список объектов:");
                    for (Sortable item : items) {
                        System.out.println(item);
                    }
                    break;
                case 5:
                    sortAndSave(items, filename);
                    System.out.println("Данные сохранены в файл " + filename);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод, попробуйте снова.");


            }
        }
    }
}