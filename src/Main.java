import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите тип ввода данных для сортировки");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных в ручную");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Выбран ввод из файла.");
                // Здесь можно добавить логику для ввода данных из файла
                break;
            case 2:
                System.out.println("Выбран ввод случайных данных.");
                // Здесь можно добавить логику для генерации случайных данных
                break;
            case 3:
                System.out.println("Выбран ввод данных вручную.");
                // Здесь можно добавить логику для ручного ввода данных
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите 1, 2 или 3.");
                break;
        }

    }
}