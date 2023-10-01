package src.algorithms;

import java.util.LinkedList;

public class InsertionSort implements  SortingAlgorithm{

    private LinkedList<Integer> insertionSortHelper(LinkedList<Integer> list){
        for(int j = 2;j <  list.size(); j++){
            int chave = list.get(j);
            int i = j -1;
            while(i >= 0 && list.get(i) > chave){
                list.set(i + 1,list.get(i));
                i = i -1;
            }
            list.set(i + 1, chave);
        }
        return list;
    }
    @Override
    public LinkedList<Integer> sort(LinkedList<Integer> list) {
        return insertionSortHelper(list);
    }
}
