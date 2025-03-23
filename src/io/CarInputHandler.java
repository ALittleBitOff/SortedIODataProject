package io;

import CustomList.MyArrayList;
import data.Car;
import io.manualInput.ManualDataInput;
import io.randomInput.RandomDataInput;
import io.textInput.FileReaderDataInput;
import search.BinarySearch;
import sort.ShellSort;

import java.io.IOException;
import java.util.Scanner;

public class CarInputHandler implements DataInputHandler{
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
                try{
                    dataRandomInputArray(scanner);
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
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

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество автомобилей не может быть отрицательным: " + length);
        }

        // Создание массива автомобилей
        MyArrayList<Car> cars = ManualDataInput.manualCarDataInput(length);

        //Сортировка списка автомобилей
        MyArrayList<Car> sortCars = cars.copy();
        ShellSort<Car> shellCarsSort = new ShellSort<>();
        shellCarsSort.sort(sortCars);

        // Вывод созданных книг
        System.out.println("Cписок автобилей:");
        cars.toPrint();

        // Вывод созданных автомобилей
        System.out.println("Отсортированный список автомобилей:");
        sortCars.toPrint();
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
        cars.toPrint();

        // Вывод созданных автомобилей
        System.out.println("Отсортированный список автомобилей:");
        sortCars.toPrint();
    }

    @Override
    public void dataRandomInputArray(Scanner scanner) throws IOException {
        System.out.print("Введите количество автомобилей: ");
        int length = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Проверка, что length не меньше 0
        if (length < 0) {
            throw new IllegalArgumentException("Количество автомобилей не может быть отрицательным: " + length);
        }

        // Создание массива автомобилей
        MyArrayList<Car> cars = RandomDataInput.createCarRandomInputArray(length);

        //Сортировка списка автомобилей
        MyArrayList<Car> sortCars = cars.copy();
        ShellSort<Car> shellCarsSort = new ShellSort<>();
        shellCarsSort.sort(sortCars);

        // Вывод созданных автомобилей
        System.out.println("Cписок автомобилей:");
        cars.toPrint();

        // Вывод созданных автомобилей
        System.out.println("Отсортированный список автомобилей:");
        sortCars.toPrint();

        // Бинарный поиск
        System.out.println("Ввод данных для поиска автомобиля:");
        System.out.println("Введите мощность (int): ");
        int power = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.println("Введите модель (String): ");
        String model = scanner.nextLine();

        System.out.println("Введите год изготовления (int): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
       Car key =  new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
        System.out.println("Key = " + key.toString());
        BinarySearch<Car> binaryCarSearch =  new BinarySearch<>();
        int index = binaryCarSearch.binarySearch(sortCars, key);
        // Вывод результата
        if (index != -1) {
            System.out.println("Элемент " + key.toString() + " найден по индексу: " + index);
        } else {
            System.out.println("Элемент " + key.toString() + " не найден в массиве.");
        }

    }
}