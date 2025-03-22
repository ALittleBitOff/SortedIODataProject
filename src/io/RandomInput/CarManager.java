package io.RandomInput;
import java.util.Random;
import java.util.Scanner;
import data.Car;
import io.manualInput.CarDataInput;
//import io.manualInput.CarDataInput;

import java.util.Random;

public class CarManager implements DataInputRandom {
    private Car[] cars;

    public void fillCarsRandomly(int numCars) {
        String[] models = {"Toyota", "Honda", "Ford", "BMW", "Mercedes"};
        Random random = new Random();
        cars = new Car[numCars];

        for (int i = 0; i < numCars; i++) {
            int power = random.nextInt(431) + 70; // Случайная сила от 70 до 500 л.с.
            String model = models[random.nextInt(models.length)]; // Случайная модель из списка
            int year = random.nextInt(34) + 1990; // Случайный год от 1990 до 2023
            cars[i] = new Car(power, model, year);
        }

        // Выводим массив автомобилей в консоль
        System.out.println("Сгенерированные автомобили:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void sort(Object[] array, String... sortBy) {

    }
}


/*import io.manualInput.BookDataInput;
import io.manualInput.CarDataInput;
import io.manualInput.KorneplodDataInput;

import java.lang.reflect.Constructor;
import java.util.Random;*/


/*// Универсальный класс для случайного заполнения данных
public class UniversalRandomDataFiller<T> implements io.RandomDataFiller<T>{
    private Class<T> clazz;
    private Random random = new Random();

    public UniversalRandomDataFiller(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T[] fillData(int size) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
        for (int i = 0; i < size; i++) {
            array[i] = createInstance(i);
        }
        return array;
    }

    public T createInstance(int index) {
        try {
            if (clazz == CarDataInput.class) {
                Constructor<T> constructor = clazz.getConstructor(int.class, String.class, int.class);
                return constructor.newInstance(random.nextInt(300) + 100, "Модель №" + random.nextInt(100), random.nextInt(30) + 1990);
            } else if (clazz == BookDataInput.class) {
                Constructor<T> constructor = clazz.getConstructor(String.class, String.class, int.class);
                return constructor.newInstance("Книга №" + random.nextInt(100), "Автор №" + (random.nextInt(10) + 1), random.nextInt(30) + 1990);
            } else if (clazz == KorneplodDataInput.class) {
                Constructor<T> constructor = clazz.getConstructor(String.class, double.class, String.class);
                return constructor.newInstance("Корнеплод №" + random.nextInt(100), random.nextDouble() * 10, "Цвет №" + random.nextInt(5) + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}*/