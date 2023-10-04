package src.enums;

import java.util.LinkedList;

import src.algorithms.*;

public enum SortingAlgorithmName {
    VOID_QUICK_SORT {
        @Override
        public String algorithmName(){
            return "QUICK_SORT";
        }
        @Override
        public LinkedList<Long> useAlgorithm(LinkedList<Long> list) {
            QuickSort sort = new QuickSort();
            return sort.sort(list);
        }

    },
    VOID_QUICK_SORT_RANDOM {

        @Override
        public LinkedList<Long> useAlgorithm(LinkedList<Long> list) {
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
        public LinkedList<Long> useAlgorithm(LinkedList<Long> list) {
            InsertionSort sort = new InsertionSort();
            return sort.sort(list);
        }

        @Override
        public String algorithmName() {
            return null;
        }
    },
    VOID_RADIX_SORT_BINARY(){
        @Override
        public LinkedList<Long> useAlgorithm(LinkedList<Long> list){
            RadixSort sort = new RadixSort();
            return sort.sort(list);
        }

        @Override
        public String algorithmName() {
            return "RADIX_SORT_BINARY";
        }
    }
    ;
    public abstract LinkedList<Long> useAlgorithm(LinkedList<Long> list);
    public abstract  String algorithmName();
}