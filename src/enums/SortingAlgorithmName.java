package src.enums;

import java.util.LinkedList;

import src.algorithms.InsertionSort;
import src.algorithms.QuickSort;
import src.algorithms.QuickSortRandom;

public enum SortingAlgorithmName {
    VOID_QUICK_SORT {
        @Override
        public String algorithmName(){
            return "QUICK_SORT";
        }
        @Override
        public LinkedList<Integer> useAlgorithm(LinkedList<Integer> list) {
            QuickSort sort = new QuickSort();
            return sort.sort(list);
        }

    },
    VOID_QUICK_SORT_RANDOM {

        @Override
        public LinkedList<Integer> useAlgorithm(LinkedList<Integer> list) {
            QuickSortRandom sort = new QuickSortRandom();
            return sort.sort(list);
        }

        @Override
        public String algorithmName() {
            return null;
        }

    },
    VOID_INSERTION_SORT {
        @Override
        public LinkedList<Integer> useAlgorithm(LinkedList<Integer> list) {
            InsertionSort sort = new InsertionSort();
            return sort.sort(list);
        }

        @Override
        public String algorithmName() {
            return null;
        }
    };
    public abstract LinkedList<Integer> useAlgorithm(LinkedList<Integer> list);
    public abstract  String algorithmName();
}