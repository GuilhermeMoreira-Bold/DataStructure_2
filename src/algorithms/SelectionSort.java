package src.algorithms;

import java.util.LinkedList;

public class SelectionSort implements SortingAlgorithm{
    public LinkedList<Integer> slectionHelper(LinkedList<Integer> list){
            int lowestIndex;
            for(int i = 0; i < list.size(); i ++){
                for(int j = i; j < list.size(); j++){
                    int currentLowest = j;
                    if(list.get(i) > list.get(j + 1) && currentLowest > list.get(j + 1)){
                        currentLowest = list.get(j + 1);
                    }else{
                        int swap = list.get(i);
                        list.set(i, list.get(j+1));
                        list.set(j, swap);
                    }
                }


        }

        return list;
    }

    @Override
    public LinkedList<Integer> sort(LinkedList<Integer> lista) {
        return null;
    }
}