package src.algorithms;

import src.controller.Movimentacoes;

import java.util.Arrays;
import java.util.LinkedList;

public class RadixOriginal implements SortingAlgorithm<Long> {

    public static void radixSort(long[] arr) {
        long max = Arrays.stream(arr).max().orElse(0);
        for (long exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(long[] arr, long exp) {
        int n = arr.length;
        long[] output = new long[n];
        long[] count = new long[10];

        for (int i = 0; i < n; i++) {
            count[(int) ((arr[i] / exp) % 10)]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[(int) (count[(int) ((arr[i] / exp) % 10)] - 1)] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
            Movimentacoes.movimentou();
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        long[] numbers = new long[lista.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lista.get(i);
        }
        radixSort(numbers);
        LinkedList<Long> sortedList = new LinkedList<>();
        for (long number : numbers) {
            sortedList.add(number);
        }
        return sortedList;
    }
}
