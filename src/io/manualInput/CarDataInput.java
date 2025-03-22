package io.manualInput;

import CustomList.MyArrayList;
import data.Car;

import java.util.Scanner;

public class CarDataInput {

    public static Car createCarFromConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите мощность (int): ");
        int power = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите модель (String): ");
        String model = scanner.nextLine();

        System.out.print("Введите год изготовления (int): ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        return new Car.Builder()
                .sethorsePower(power)
                .setmodel(model)
                .setreleaseYear(year)
                .build();
    }

    public static MyArrayList<Car> createCarArrayFromConsole(int length) {

        MyArrayList<Car> myCarList = new MyArrayList<>();
//        ShellSort<Car> shellCarSort = new ShellSort<>();

        for (int i = 0; i < length; i++) {
            System.out.println("Введите количество машин " + (i + 1) + ":");
            myCarList.add(createCarFromConsole());
        }

//        shellCarSort.sort(myCarList);

        return myCarList;
    }
}