package io;

import CustomList.MyArrayList;
import data.Car;
import io.manualInput.CarDataInput;
import io.textInput.FileReaderDataInput;
import sort.ShellSort;

import java.io.IOException;
import java.util.Scanner;

public class CarInputHandler implements DataInputHandler {
    @Override
    public void handleInput(Scanner scanner) {
        System.out.println("Выберите способ ввода данных для автомобиля:");
        System.out.println("1 - ввод из файла");
        System.out.println("2 - ввод случайных данных");
        System.out.println("3 - ввод данных вручную");

        int subChoice = scanner.nextInt();
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
                System.out.println("Ввод случайных данных для автомобиля.");
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
        MyArrayList<Car> cars = CarDataInput.createCarArrayFromConsole(length);

        //Сортировка списка автомобилей
        MyArrayList<Car> sortCars = cars.copy();
        ShellSort<Car> shellCarsSort = new ShellSort<>();
        shellCarsSort.sort(sortCars);

        // Вывод созданных книг
        System.out.println("Cписок автобилей:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }

        // Вывод созданных автомобилей
        System.out.println("Отсортированный список автомобилей:");
        for (int i = 0; i < sortCars.size(); i++) {
            System.out.println(sortCars.get(i).toString());
        }
    }

    @Override
    public void dataTextInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите название файла *name* .txt: ");
        String filePath = "src/test/resoursec/car/"+scanner.next()+".txt";
        scanner.nextLine();
        System.out.println("Путь до считываемого файла "+filePath);

        //Список автомобилей
        MyArrayList<Car> cars = FileReaderDataInput.readCarsFromFile(filePath);

        //Сортировка списка автомобилей
        MyArrayList<Car> sortCars = cars.copy();
        ShellSort<Car> shellCarsSort = new ShellSort<>();
        shellCarsSort.sort(sortCars);

        // Вывод созданных автомобилей
        System.out.println("Cписок автомобилей:");
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }

        // Вывод созданных автомобилей
        System.out.println("Отсортированный список автомобилей:");
        for (int i = 0; i < sortCars.size(); i++) {
            System.out.println(sortCars.get(i).toString());
        }
    }


}