package src.algorithms;

import src.controller.Comparacoes;
import src.controller.Movimentacoes;

import java.util.Arrays;
import java.util.LinkedList;

public class Quick implements SortingAlgorithm<Long> {
    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        if (lista == null || lista.size() <= 1) {
            return lista;
        }

        // Converta a LinkedList para um array
        Long[] array = lista.toArray(new Long[0]);


        sort(array, 0, array.length - 1);


        return new LinkedList<>(Arrays.asList(array));
    }

    private static void sort(Long[] a, int lo, int hi) {
        if (hi <= lo) return;


        int mid = lo + (hi - lo) / 2;
        exch(a, lo, mid);

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Long[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Long v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                Movimentacoes.movimentou();
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                Movimentacoes.movimentou();
                if (j == lo) break;
            }
            if (i >= j) break;

            Comparacoes.comparou();
            exch(a, i, j);
        }

        Comparacoes.comparou();
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Long v, Long w) {
        Comparacoes.comparou();
        return v.compareTo(w) < 0;
    }

    private static void exch(Long[] a, int i, int j) {
        Long t = a[i];
        a[i] = a[j];
        a[j] = t;
        Movimentacoes.movimentou();
    }
}