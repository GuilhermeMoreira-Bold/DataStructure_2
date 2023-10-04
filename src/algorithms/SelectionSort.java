package src.algorithms;

import java.util.LinkedList;

public class SelectionSort implements SortingAlgorithm{
    public LinkedList<Long> slectionHelper(LinkedList<Long> list){
            int lowestIndex;
            for(int i = 0; i < list.size(); i ++){
                for(int j = i; j < list.size(); j++){
                    long currentLowest = j;
                    if(list.get(i) > list.get(j + 1) && currentLowest > list.get(j + 1)){
                        currentLowest = list.get(j + 1);
                    }else{
                        long swap = list.get(i);
                        list.set(i, list.get(j+1));
                        list.set(j, swap);
                    }
                }


        }

        return list;
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        return null;
    }
}