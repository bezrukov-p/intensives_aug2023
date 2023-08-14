package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7PrimeNumbers {
    public static int[] findPrimes (int N) {
        /*
         * 2 <= N <= 10^6
         * Выход: отсортированный массив всех простых чисел от 2 до N
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        List<Integer> result = new ArrayList<>();
        boolean[] primesInfo = new boolean[N + 1];
        Arrays.fill(primesInfo, true);
        int sqrtN = (int) Math.sqrt(N) + 1;

        for (int i = 2; i < sqrtN; i++) {
            int coeff = 2;
            while (coeff * i <= N)
                primesInfo[coeff++ * i] = false;
        }

        for (int i = 2; i < primesInfo.length; i++) {
            if (primesInfo[i])
                result.add(i);
        }


        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }
}
