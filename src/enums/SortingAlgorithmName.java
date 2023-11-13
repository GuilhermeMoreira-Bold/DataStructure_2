package src.enums;

import java.util.Comparator;
import java.util.LinkedList;
import src.algorithms.*;


public enum SortingAlgorithmName {
    VOID_QUICK_SORT {
        @Override
        public String algorithmName(){
            return "QUICK_SORT";
        }
        @Override
        public <T> LinkedList <T> useAlgorithm(LinkedList<T> list) {
            QuickSort sort = new QuickSort();
            return ((LinkedList<T>) sort.sort((LinkedList<Long>) list));
        }

    },
    VOID_QUICK_SORT_RANDOM {

        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            QuickSortRandom sort = new QuickSortRandom();
            return (LinkedList<T>) sort.sort((LinkedList<Long>) list);
        }

        @Override
        public String algorithmName() {
            return null;
        }

    },
    VOID_INSERTION_SORT {
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            InsertionSort sort = new InsertionSort();
            return (LinkedList<T>) sort.sort((LinkedList<Long>) list);
        }

        @Override
        public String algorithmName() {
            return null;
        }
    },
    VOID_RADIX_ORIGINAL(){
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            RadixOriginal sort = new RadixOriginal();
            return (LinkedList<T>) sort.sort((LinkedList<Long>) list);
        }

        @Override
        public String algorithmName() {
            return "RADIX_SORT_ORIGINAL";
        }
    },
    VOID_RADIX_INTEGER(){
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            RadixSortInteger sort = new RadixSortInteger();
            return (LinkedList<T>) sort.sort((LinkedList<Integer>) list);
        }

        @Override
        public String algorithmName() {
            return "RADIX_INTEGER";
        }
    },
    VOID_RADIX_SORT_BINARY(){
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list){
            RadixSort sort = new RadixSort();
            return (LinkedList<T>) sort.sort((LinkedList<Long>) list);
        }

        @Override
        public String algorithmName() {
            return "RADIX_SORT_BINARY";
        }
    }
    ;
    public abstract <T> LinkedList<T> useAlgorithm(LinkedList<T> list);
    public abstract  String algorithmName();
}