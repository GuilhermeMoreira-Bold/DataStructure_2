package src.algorithms;

import java.util.LinkedList;

import src.controller.Comparacoes;
import src.controller.Movimentacoes;

public class QuickSort implements SortingAlgorithm {
    private LinkedList<Long> list = new LinkedList<Long>();

    private void quickSortHelper(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            quickSortHelper(left, pivotIndex - 1);
            quickSortHelper(pivotIndex + 1, right);
        }
    }

    private int partition(int left, int right) {
        long pivot = this.list.get(right);
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (list.get(j) <= pivot) {
                Comparacoes.comparou();
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, right);
        return i + 1;
    }

    private void swap(int i, int j) {
        Movimentacoes.movimentou();
        long temp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, temp);
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        this.list = lista;
        quickSortHelper(0, list.size() - 1);
        return this.list;
    }

}