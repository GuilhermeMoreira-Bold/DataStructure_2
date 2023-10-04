package src.binary;

import java.util.LinkedList;

public class Binary {

    public static LinkedList<String> list(LinkedList<Long> list){
        LinkedList<String> numbers = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) >= 0){
                numbers.add(decimalToBinary(list.get(i)));
                continue;
            }
            numbers.add(decimalToBinaryNegative(list.get(i)));
        }
        return numbers;
    }
    public static LinkedList<Long> listDecimal(LinkedList<String> list){
        LinkedList<Long> numbers = new LinkedList<>();
        for (int i = 0;i < list.size() ; i++) {
            StringBuilder builder = new StringBuilder(list.get(i));
            if(builder.charAt(0) == '1'){
                String positiveBinary = plusOneBinary(flipBinary(builder.toString()));
                numbers.add(binaryToDecimal(positiveBinary) * -1);
                continue;
            }
            numbers.add(binaryToDecimal(builder.toString()));
        }
        return numbers;
    }

    private static long binaryToDecimal(String number){

        StringBuilder builder = new StringBuilder(number);
        long decimalNumber = 0L;
        builder.reverse();

        for(int i =  0; i < number.length(); i++){
            decimalNumber += (builder.charAt(i) - '0') * (long) Math.pow(2,i);
        }
        return decimalNumber;
    }

    private static String decimalToBinary(long number){
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            builder.append(number % 2);
            number /= 2;
        }
        for(int i = 0; builder.length() < 64; i ++){
            builder.append("0");
        }
        return  builder.reverse().toString();
    }

    private static String decimalToBinaryNegative(long number){
        String binaryNegative = decimalToBinary(number * -1);
        binaryNegative = flipBinary(binaryNegative);
        binaryNegative = plusOneBinary(binaryNegative);
        return binaryNegative;
    }
    private static String plusOneBinary(String binaryNumber){
        char zero = '0';
        char one = '1';
        StringBuilder builder = new StringBuilder(binaryNumber);
        for(int j = binaryNumber.length() -1; j >= 0; j--){
            if(binaryNumber.charAt(j) == '0'){
                builder.setCharAt(j, one);
                break;
            }
            builder.setCharAt(j, zero);
        }
        return builder.toString();
    }
    private static String flipBinary(String numberToFlip){
        StringBuilder builder = new StringBuilder(numberToFlip);
        char zero = '0';
        char one = '1';
        for(int i = 0; i < builder.length(); i++){
            if(builder.charAt(i) == '0'){
                builder.setCharAt(i, one);
                continue;
            }
            builder.setCharAt(i, zero);
        }
        return  builder.toString();
    }


}
