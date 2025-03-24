## Пример использования
После запуска программы пользователю предлагается выбрать действие:

1. Выберите категорию данных:
   - 1️⃣ Автомобили
   - 2️⃣ Книги
   - 3️⃣ Корнеплоды

2. Выберите способ ввода:
   - 1️⃣ Ввод из файла
   - 2️⃣ Случайная генерация
   - 3️⃣ Ручной ввод

3. После ввода данных:
   - Выводится список элементов
   - Выполняется сортировка и вывод отсортированного списка
   - Предлагается выполнить бинарный поиск:
      - 1️⃣ Да
      - 2️⃣ Нет

После завершения всех операций программа завершает работу.



# SortedIODataProject

## Пошаговое руководство по реализации приложения для сортировки на Java

### Общий обзор задания
Создание консольного приложения для сортировки объектов с использованием пользовательских классов и реализации алгоритмов сортировки и поиска. Программа будет циклически запрашивать действия у пользователя.

### Шаг 1: Определение структуры проекта
1. **Создайте проект** в вашей IDE (например, IntelliJ IDEA).
2. **Создайте пакеты**:
    - `data` — для классов данных.
    - `sort` — для реализации алгоритмов сортировки.
    - `search` — для реализации алгоритмов поиска.
    - `collection` — для пользовательских реализаций коллекций.
    - `io` — для взаимодействия с пользователем.

### Шаг 2: Реализация классов данных
Создайте три класса в пакете `models`:

#### 2.1. Класс `Car`
```java
package data;

public class Car {
    private int horsePower;
    private String model;
    private int releaseYear

    // Конструктор и геттеры/сеттеры
}
```

#### 2.2. Класс `Book`
```java
package data;

public class Book {
    private String author;
    private String title;
    private int pageCount;

    // Конструктор и геттеры/сеттеры
}
```

#### 2.3. Класс `RootVegetable`
```java
package data;

public class Kornaplod {
    private String type;
    private double weight;
    private String color;

    // Конструктор и геттеры/сеттеры
}
```

### Шаг 3: Реализация пользовательской коллекции
Создайте класс `MyArrayList` или `MyLinkedList` в пакете `collection` с необходимыми методами для работы с массивами:

```java
package CustomList;

public class MyArrayList<T> {
    private Object[] elements;
    private int size;

    // Конструкторы и методы (add, remove, get, size)
}
```

### Шаг 4: Реализация алгоритма сортировки
Создайте класс `ShellSort` в пакете `sort` с методом `sort` для сортировки массивов.

```java
package sort;

public class ShellSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        // Реализация алгоритма сортировки Шелла
    }
}
```

### Шаг 5: Реализация бинарного поиска
Создайте класс `BinarySearch` в пакете `search`:

```java
package search;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(T[] array, T key) {
        // Реализация бинарного поиска
    }
}
```

### Шаг 6: Реализация паттерна "Стратегия" для сортировок
Создайте интерфейс `SortStrategy` и его реализацию для сортировки:

```java
package sort;

public interface SortStrategy<T> {
    void sort(T[] array);
}
```

### Шаг 7: Реализация пользовательского интерфейса
Создайте класс `Main` в пакете `ui`, который будет взаимодействовать с пользователем:

```java
import io.BookInputHandler;
import io.CarInputHandler;
import io.DataInputHandler;
import io.KornepodInputHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Создаем карту для хранения обработчиков ввода
        Map<Integer, DataInputHandler> inputHandlers = new HashMap<>();
        inputHandlers.put(1, new CarInputHandler());
        inputHandlers.put(2, new BookInputHandler());
        inputHandlers.put(3, new KornepodInputHandler());

        do {....
     
        } while (true);

        scanner.close();
    }
```

### Шаг 8: Валидация данных
Добавьте методы валидации для данных, вводимых пользователем, и данных, загружаемых из файлов.

### Шаг 9: Дополнительные функции
1. Реализуйте логику сортировки по четным/нечетным полям.
2. Реализуйте функционал записи в файл.

### Шаг 10: Версионирование и структуру веток на GitHub/GitLab
1. **Создайте репозиторий**.
2. **Создайте ветки** для каждого участника группы:
    - `AlittleBitOff`
    - `Opaii`
    - `Danila`
    - `RAO`
    - `main`

3. **Смерджите** все ветки в основную (`main`) после завершения работы.

### Шаг 11: Подготовка к демонстрации
Подготовьте README файл с описанием проекта, инструкциями по установке и запуску, а также комментариями
к коду.

## Заключение
Следуя этим шагам, вы сможете успешно реализовать ваше приложение для сортировки и поиска с учетом всех
требований. Уделяйте внимание дизайну, чистоте кода и документированию. Удачи в разработке!

Общая часть задания: написать приложение, которое будет реализовывать алгоритм сортировки по переданным
классам. Приложение должно быть выложено на гитхаб/гитлаб, количество веток с кодом должно соответствовать
количеству участников (минимум), все ветки в итоге должны быть смерджены в master/main ветку. Вся 
архитектура и код стайл должны соответствовать конвенциям языка Java.Программа должна выполняться в цикле.
Выход из цикла возможен только путем соответствующего выбора пользователя. Пользователь должен иметь
возможность выбирать варианты заполнения исходного массива данных (из файла, рандом, вручную) и его длину.
Также у пользователя должна быть возможность найти какой-либо элемент отсортированной коллекции при помощи
алгоритма бинарного поиска, которые также необходимо реализовать. Сотрировки и бинарный поиск должны быть
реализованы с использованием дженериков и быть универсальными под любые классы программы. В программе 
должен использовать паттерн стратегия. Сортировать необходимо кастомные классы - класс должен иметь
реализованный паттерн Builder. Для вводимых данных (в тч из файла) должна производится валидация данных.
Доп. задание: дополнительно к основным сортировкам реализовать эти же алгоритмы сортировки таким образом,
что классы будут сортироваться по какому-либо числовому полю таким образом, что классы с четными значениями
будут сортироваться в натуральном порядке, а с нечетными оставаться на своих местах.
Доп. доп. задание: Необходимо реализовать функционал для записи отсортированных коллекций/найденных 
значений в файл в режиме добавления данных
Все классы должны базово имплементировать сортировку по всем 3 полям. Для кастомной сортировки можно
использовать компаратор. Использовать готовые реализации сортировок и поиска нельзя. Работа должна
производится с массивами.

@lafeison  - Классы: Автомобиль (Мощность, Модель, Год производства), Книга (Автора, Название,
Количество страниц), Корнеплод (Тип, Вес, Цвет) Сортировка - ShellSort

ВАЖНО: В качестве коллекции необходимо сделать собственную реализацию ArrayList/LinkedList (кому
как больше хочется). Использовать готовые коллекции в Java, а также функционал класса Collections 
запрещено.
ВАЖНО 2: В доп задании на сортировку объектов по чентым/нечетным числовым полям допускается 
использовать готовые алгоритмы сортировки и коллекции Java, но в этом случае эта часть задания
должна быть выполнена с использованием Java Stream API
ВАЖНО 3: Использовать аннотацию @Builder (Lombok) запрещено
