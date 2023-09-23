package src.enums;

import java.util.LinkedList;

import src.algorithms.QuickSort;

public enum SortingAlgorithmName {
    VOID_QUICK_SORT {

        @Override
        public LinkedList<Integer> useAlgorithm(LinkedList<Integer> list) {
            QuickSort sort = new QuickSort();
            return sort.sort(list);
        }

    },
    VOID_INSERTION_SORT {
        @Override
        public LinkedList<Integer> useAlgorithm(LinkedList<Integer> list) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'chooseAlgorithm'");
        }
    };

    public abstract LinkedList<Integer> useAlgorithm(LinkedList<Integer> list);
}