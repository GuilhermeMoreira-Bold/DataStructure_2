package src.algorithms;

import java.util.LinkedList;
import java.util.Random;

import src.controller.Comparacoes;
import src.controller.Movimentacoes;

public class QuickSortRandom implements SortingAlgorithm {
    private LinkedList<Integer> list = new LinkedList<Integer>();

    public void quickSortHelper(int left, int right) {
        if (left < right) {
            Comparacoes.comparou();

            Random random = new Random();
            int pivotIndex = left + random.nextInt((right - left) + 1);

            int pivot = this.list.get(pivotIndex);

            Movimentacoes.movimentou();
            this.list.set(pivotIndex, this.list.get(right));

            Movimentacoes.movimentou();
            this.list.set(right, pivot);

            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (this.list.get(j) <= pivot) {
                    Comparacoes.comparou();
                    i++;
                    swap(i, j);
                }
            }

            swap(i + 1, right);

            quickSortHelper(left, i);
            quickSortHelper(i + 2, right);
        }
    }

    private void swap(int i, int j) {
        Movimentacoes.movimentou();
        int temp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, temp);
    }

    @Override
    public LinkedList<Integer> sort(LinkedList<Integer> list) {
        this.list = list;
        quickSortHelper(0, this.list.size() - 1);
        return this.list;
    }
}