package src.algorithms;

import src.controller.Movimentacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class RadixSortInteger implements SortingAlgorithm<Integer>{
    private ArrayList<Integer> positive = new ArrayList<>();
    private ArrayList<Integer> negative = new ArrayList<>();

    private void radixHelper(LinkedList<Integer> list) {
        for (Integer number : list) {
            if (number >= 0) {
                positive.add(number);
            } else {
                negative.add(number);
            }
        }
    }

    private ArrayList<Integer> radixDistribute(ArrayList<Integer> list, int bitIndex) {
        if (list.isEmpty() || bitIndex < 0) {
            return list;
        }

        ArrayList<Integer> bucketZero = new ArrayList<>();
        ArrayList<Integer> bucketOne = new ArrayList<>();

        for (Integer number : list) {
            int mask = 1 << bitIndex;
            if ((number & mask) == 0) {
                bucketZero.add(number);
                Movimentacoes.movimentou();
            } else {
                bucketOne.add(number);
                Movimentacoes.movimentou();
            }
        }

        ArrayList<Integer> newOrders = new ArrayList<>();
        newOrders.addAll(radixDistribute(bucketZero, bitIndex - 1));
        newOrders.addAll(radixDistribute(bucketOne, bitIndex - 1));

        return newOrders;
    }

    @Override
    public LinkedList<Integer> sort(LinkedList<Integer> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista de entrada não pode ser nula.");
        }

        radixHelper(lista);

        ArrayList<Integer> sortedList = new ArrayList<>(lista.size());
        sortedList.addAll(radixDistribute(negative, 31));
        sortedList.addAll(radixDistribute(positive, 31));

        return new LinkedList<>(sortedList);
    }
}
