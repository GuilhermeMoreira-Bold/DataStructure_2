package src.algorithms;

import java.util.LinkedList;

public class InsertionSort implements  SortingAlgorithm{

    private LinkedList<Long> insertionSortHelper(LinkedList<Long> list){
        for(int j = 2;j <  list.size(); j++){
            long chave = list.get(j);
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
    public LinkedList<Long> sort(LinkedList<Long> list) {
        return insertionSortHelper(list);
    }
}
