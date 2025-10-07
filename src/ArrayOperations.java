import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Ошибка: Размер массива должен быть больше нуля.");
            return;
        }

        System.out.print("Введите нижнюю границу диапазона случайных чисел: ");
        int lowerBound = scanner.nextInt();

        System.out.print("Введите верхнюю границу диапазона случайных чисел: ");
        int upperBound = scanner.nextInt();

        // Создаем и обрабатываем массив целых чисел
        int[] intArray = generateRandomIntArray(size, lowerBound, upperBound);
        System.out.println("Исходный массив целых чисел: " + Arrays.toString(intArray));
        printStatistics(intArray);
        sortArrayAscending(intArray);
        System.out.println("Отсортированный по возрастанию массив целых чисел: " + Arrays.toString(intArray));
        sortArrayDescending(intArray);
        System.out.println("Отсортированный по убыванию массив целых чисел: " + Arrays.toString(intArray));

        System.out.println();

        // Создаем и обрабатываем массив чисел с плавающей точкой
        double[] doubleArray = generateRandomDoubleArray(size, lowerBound, upperBound);
        System.out.println("Исходный массив чисел с плавающей точкой: " + Arrays.toString(doubleArray));
        printStatistics(doubleArray);
        sortArrayAscending(doubleArray);
        System.out.println("Отсортированный по возрастанию массив чисел с плавающей точкой: " + Arrays.toString(doubleArray));
        sortArrayDescending(doubleArray);
        System.out.println("Отсортированный по убыванию массив чисел с плавающей точкой: " + Arrays.toString(doubleArray));

        scanner.close();
    }

    // Методы для работы с массивом целых чисел

    public static int[] generateRandomIntArray(int size, int lowerBound, int upperBound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        }
        return array;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    public static void sortArrayAscending(int[] array) {
        Arrays.sort(array);  // Используем встроенную сортировку для простоты
    }

    public static void sortArrayDescending(int[] array) {
        Arrays.sort(array); // Сначала сортируем по возрастанию
        reverseArray(array); // Затем переворачиваем
    }

    // Методы для работы с массивом чисел с плавающей точкой

    public static double[] generateRandomDoubleArray(int size, int lowerBound, int upperBound) {
        double[] array = new double[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = lowerBound + (upperBound - lowerBound) * random.nextDouble();
        }
        return array;
    }

    public static double findMax(double[] array) {
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static double findMin(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static double calculateAverage(double[] array) {
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }

    public static void sortArrayAscending(double[] array) {
        Arrays.sort(array); // Используем встроенную сортировку для простоты
    }

    public static void sortArrayDescending(double[] array) {
        Arrays.sort(array); // Сначала сортируем по возрастанию
        reverseArray(array); // Затем переворачиваем
    }

    // Вспомогательные методы

    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    private static void reverseArray(double[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            double temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void printStatistics(int[] array) {
        System.out.println("Максимальное значение: " + findMax(array));
        System.out.println("Минимальное значение: " + findMin(array));
        System.out.println("Среднее значение: " + calculateAverage(array));
    }

    public static void printStatistics(double[] array) {
        System.out.println("Максимальное значение: " + findMax(array));
        System.out.println("Минимальное значение: " + findMin(array));
        System.out.println("Среднее значение: " + calculateAverage(array));
    }
}
