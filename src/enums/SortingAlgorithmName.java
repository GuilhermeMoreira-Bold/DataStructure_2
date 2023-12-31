package src.enums;

import java.util.LinkedList;

import src.Tree.AVLTree;
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
    VOID_NEW_RADIX{
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            RadixSort2 sort = new RadixSort2();
            return ((LinkedList<T>) sort.sort((LinkedList<Long>) list));
        }

        @Override
        public String algorithmName() {
            return "NEW_RADIX";
        }
    },
    VOID_AVL_TREE{
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            AVLTree<Long> avl = new AVLTree<>();
            for(int i = 0; i < list.size(); i ++){
                avl.insert((Long) list.get(i));
            }
            return ((LinkedList<T>) avl.sort((LinkedList<Long>) list));
        }

        @Override
        public String algorithmName() {
            return "AVL";
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
    VOID_QUICK_SORT_ALGORITHM_BOOK {
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list) {
            Quick quick = new Quick();
            return  (LinkedList<T>) quick.sort((LinkedList<Long>) list);
        }

        @Override
        public String algorithmName() {
            return "QuicksortOriginal";
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
    VOID_ORBIT_SORT(){
        @Override
        public <T> LinkedList<T> useAlgorithm(LinkedList<T> list){
            OrbitSort sort = new OrbitSort();
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