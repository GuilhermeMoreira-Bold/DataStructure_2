package src.algorithms;

import src.controller.Movimentacoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class RadixSort2 implements SortingAlgorithm<Long> {
    private ArrayList<Long> positive = new ArrayList<>();
    private ArrayList<Long> negative = new ArrayList<>();

    private void radixHelper(LinkedList<Long> list) {
        for (Long number : list) {
            if (number >= 0) {
                positive.add(number);
            } else {
                negative.add(-number); // Evitar ~ e simplificar
            }
        }
    }

    private ArrayList<Long> radixDistribute(ArrayList<Long> list) {
        LinkedList<Long> result = new LinkedList<>(list);
        for (int bitIndex = 63; bitIndex >= 0; bitIndex--) {
            LinkedList<Long> bucketZero = new LinkedList<>();
            LinkedList<Long> bucketOne = new LinkedList<>();
            long mask = 1L << bitIndex;

            while (!result.isEmpty()) {
                Long number = result.removeFirst();
                if ((number & mask) == 0) {
                    bucketZero.add(number);
                } else {
                    bucketOne.add(number);
                }
            }

            result.addAll(bucketZero);
            result.addAll(bucketOne);
        }

        return new ArrayList<>(result);
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("A lista de entrada não pode ser nula.");
        }

        radixHelper(lista);

        ArrayList<Long> sortedList = new ArrayList<>(lista.size());
        sortedList.addAll(radixDistribute(negative));
        Collections.reverse(sortedList);
        sortedList.addAll(radixDistribute(positive));

        LinkedList<Long> result = new LinkedList<>(sortedList);

        for (int i = 0; i < negative.size(); i++) {
            result.set(i, -result.get(i));
        }

        return result;
    }
}
