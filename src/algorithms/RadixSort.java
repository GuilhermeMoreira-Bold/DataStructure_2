package src.algorithms;

import src.binary.Binary;
import src.controller.Movimentacoes;

import java.util.LinkedList;

public class RadixSort implements SortingAlgorithm{
    private LinkedList<String> positive = new LinkedList<>();
    private LinkedList<String> negative = new LinkedList<>();

    private LinkedList<String> bucketZero = new LinkedList<>();

    private LinkedList<String> bucketOne = new LinkedList<>();

    public void radixHelper(LinkedList<String> list){
        for(int i = 0; i < list.size(); i ++){
            StringBuilder builder = new StringBuilder(list.get(i));
            if(builder.charAt(0) == '0'){
                positive.add(builder.toString());
                continue;
            }
            negative.add(builder.toString());
        }
    }
    public LinkedList<Long> radixDistribute(LinkedList<String> list, int bits){
        LinkedList<String> newOrders = list;
        for (int i = bits; i >= 0; i--) {
            bucketZero.clear();
            bucketOne.clear();

            for (String number : newOrders) {
                if (number.charAt(i) == '0') {
                    Movimentacoes.movimentou();
                    bucketZero.add(number);
                    continue;
                }
                    bucketOne.add(number);
                    Movimentacoes.movimentou();
            }

            newOrders.clear();
            newOrders.addAll(bucketZero);
            newOrders.addAll(bucketOne);
        }

        return Binary.listDecimal(newOrders);
    }

    @Override
    public LinkedList<Long> sort(LinkedList<Long> lista) {
        LinkedList<Long> positiveDecimal = new LinkedList<>();


        radixHelper(Binary.list(lista));
        LinkedList<Long> list = new LinkedList<>(radixDistribute(negative, 63));
        positiveDecimal = radixDistribute(positive, 63);

        list.addAll(positiveDecimal);

        return list;
    }
}
