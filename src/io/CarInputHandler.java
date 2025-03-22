package io;
import java.util.Random;
//import io.RandomInput.CarManager;
import data.Car;
import io.manualInput.CarDataInput;
import io.textInput.FileReaderDataInput;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import io.RandomInput.CarManager;

public class CarInputHandler implements DataInputHandler {
    private Car[] cars;

    @Override
    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных для автомобиля:");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных вручную");

        int subChoice = scanner.nextInt();
        int size = scanner.nextInt();



        switch (subChoice) {
            case 1:
                System.out.println("Ввод данных для автомобиля из файла.");
                // Логика для ввода из файла
                try{
                    dataTextInputArray(scanner);
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.println("Введите количество автомобилей для генерации:");
                int numCars = scanner.nextInt();
                CarManager carManager = new CarManager();
                carManager.fillCarsRandomly(numCars);

                /*System.out.println("Вывод случайных данных для автомобиля.");
                // Логика для ввода случайных данных
                break;
            case 3:
                System.out.println("Ввод данных для автомобиля вручную.");
                handleManualInputArray(scanner);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    @Override
    public void handleManualInputArray(Scanner scanner) {
        System.out.print("Введите количество автомобилей: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Создание массива автомобилей
        Car[] cars = CarDataInput.createCarArrayFromConsole(length);

        // Вывод созданных автомобилей
        System.out.println("Список автомобилей:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/car/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println(filePath);
        List<Car> cars = FileReaderDataInput.readCarsFromFile(filePath);

        // Вывод созданных автомобилей
        System.out.println("Список автомобилей:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }


}