package src.algorithms;

import src.controller.Movimentacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class RadixSort implements SortingAlgorithm<Long>{
    private ArrayList<Long> positive = new ArrayList<>();
    private ArrayList<Long> negative = new ArrayList<>();

    private void radixHelper(LinkedList<Long> list) {
        for (Long number : list) {
            if (number >= 0) {
                positive.add(number);
            } else {
                negative.add(number);
            }
        }
    }

    private ArrayList<Long> radixDistribute(ArrayList<Long> list, int bitIndex) {
        if (list.isEmpty() || bitIndex < 0) {
            return list;
        }

        ArrayList<Long> bucketZero = new ArrayList<>();
        ArrayList<Long> bucketOne = new ArrayList<>();

        for (Long number : list) {
            long mask = 1L << bitIndex;
            if ((number & mask) == 0) {
                bucketZero.add(number);
//                Movimentacoes.movimentou();
            } else {
                bucketOne.add(number);
//                Movimentacoes.movimentou();
            }
        }

        ArrayList<Long> newOrders = new ArrayList<>();
        newOrders.addAll(radixDistribute(bucketZero, bitIndex - 1));
        newOrders.addAll(radixDistribute(bucketOne, bitIndex - 1));

        return newOrders;
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista de entrada não pode ser nula.");
        }

        radixHelper(lista);

        ArrayList<Long> sortedList = new ArrayList<>(lista.size());
        sortedList.addAll(radixDistribute(negative, 63));
        sortedList.addAll(radixDistribute(positive, 63));

        LinkedList<Long> result = new LinkedList<>(sortedList);




        return result;
    }
}
