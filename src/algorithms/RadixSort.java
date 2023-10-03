package src.algorithms;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class RadixSort {
    private static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private static void countSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
    }

    // The main function to implement radix sort
    public static void radixSort(int arr[]) {
        // Find the maximum number to know the number of digits
        int max = getMax(arr);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is the current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    // A utility function to print an array
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);

//        int number = Integer.parseInt(JOptionPane.showInputDialog("Write the number"));
//
//        String binaryStringPositive =  Integer.toBinaryString(number);
//        String binaryStringNegative =  Integer.toBinaryString(-number);
//
//
//        System.out.println("Binary representation of: " + decimalToBinary( 20));
//        System.out.println("Binary representation of: " + -number+ "\n" + binaryStringNegative);
//
//
//
//        System.out.println("Binary to decimal:" + Integer.parseInt(decimalToBinary( 20),2 ));


//        int number2 = Integer.parseInt(binaryStringNegative,2);



        System.out.println(decimalToBinaryNegative(decimalToBinary(3)));
        System.out.println( decimalToBinary( 4));
        System.out.println(decimalToBinaryNegative(decimalToBinary(2)));
        System.out.println( decimalToBinary( 1));
        System.out.println( decimalToBinary( 5));
        System.out.println( decimalToBinary( 2));
    }

    public static String decimalToBinary(int number){
        StringBuilder builder = new StringBuilder();
        while (number != 0) {
            builder.append(number % 2);
            number /= 2;
        }
        for(int i = 0; builder.length() < 32; i ++){
            builder.append("0");
        }
        return  builder.reverse().toString();
    }

    public static String decimalToBinaryNegative(String number){
        StringBuilder builder = new StringBuilder(number);
        char zero = '0';
        char one = '1';
        for(int i = 0; i < number.length(); i++){
            if(builder.charAt(i) == '0'){
                builder.setCharAt(i, one);
                continue;
            }
                builder.setCharAt(i, zero);
        }
        for(int j = number.length() -1; j >= 0; j--){
            if(builder.charAt(j) == '0'){
                builder.setCharAt(j, one);
                break;
            }
            builder.setCharAt(j, zero);
        }
        return builder.toString();
    }
}
