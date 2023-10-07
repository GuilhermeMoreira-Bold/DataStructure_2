package src.algorithms;

import src.controller.Movimentacoes;

import java.util.ArrayList;
import java.util.LinkedList;

public class RadixOriginal implements SortingAlgorithm<Long> {

    private void countSort(LinkedList<Long> lista, long exp) {
        int n = lista.size();
        ArrayList<Long> output = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            output.add(0L);
        }

        int[] count = new int[10];
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Count occurrences of digits at the current exp position
        for (Long num : lista) {
            int digit = Math.floorMod((int) ((num / exp) % 10), 10);
            count[digit]++;
        }

        // Update count[i] to store the position of the current digit in the output array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in a stable manner
        for (int i = n - 1; i >= 0; i--) {
            Long num = lista.get(i);
            int digit = Math.floorMod((int) ((num / exp) % 10), 10);
            output.set(count[digit] - 1, num);
            Movimentacoes.movimentou();
            count[digit]--;
        }

        // Copy the output array back to the original list
        for (int i = 0; i < n; i++) {
            lista.set(i, output.get(i));
        }
    }

    private long getMax(LinkedList<Long> lista) {
        long max = lista.getFirst();
        for (Long num : lista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        long max = getMax(lista);

        int numDigits = (int) (Math.log10(max) + 1);

        for (int exp = 1; exp <= Math.pow(10, numDigits); exp *= 10) {
            countSort(lista, exp);
        }

        return lista;
    }
}
