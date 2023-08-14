package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой вставками!) numbers
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        for (int i = 1; i < numbers.size(); i++) {
            int ind = i - 1;
            while (ind >= 0) {
                if (numbers.get(ind) > numbers.get(ind + 1)) {
                    swap(numbers, ind, ind + 1);
                }
                else {
                    break;
                }
                ind--;
            }
        }
        return numbers;
    }

    private static void swap(ArrayList<Integer> arr, int l, int r) {
        int tmp = arr.get(l);
        arr.set(l, arr.get(r));
        arr.set(r, tmp);
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
