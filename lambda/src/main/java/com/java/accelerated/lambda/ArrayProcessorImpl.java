package com.java.accelerated.lambda;

import java.util.Arrays;

public class ArrayProcessorImpl {

    static double[] b = new double[]{1, 4, 5, 2, 8, 10, 20, 11, 20};
    static double maxNum = 0;
    static double count = 0;
    static double average = 0;
    static double frequency = 0;

    //    The  value returned is as lambda expression.
    public static ArrayProcessor counter(double value) {
        return (data) ->
        {
            for (int i = 0; i < data.length; i++) {
                if (value == data[i]) {
                    frequency++;
                }
            }
            return frequency;
        };
    }

    public static void main(String[] args) {
        final ArrayProcessor max = (data) -> {
            for (int i = 0; i < data.length; i++) {
                if (data[i] > maxNum) {
                    maxNum = data[i];
                }
            }
            return maxNum;
        };
        System.out.println(max.apply(b));

        final ArrayProcessor min = (data) -> {
            Arrays.sort(data);
            return data[0];
        };
        System.out.println(min.apply(b));

        final ArrayProcessor sum = (data) -> {
            for (int i = 0; i < data.length; i++) {
                count += data[i];
            }
            return count;
        };
        System.out.println(sum.apply(b));

        final ArrayProcessor avg = (data) -> {
            count = 0;
            for (int i = 0; i < data.length; i++) {
                count += data[i];
            }
            average = count / data.length;
            return average;
        };
        System.out.println(avg.apply(b));

//  function returning an ArrayProcessor that counts the number of times that value occurs in an array.
        ArrayProcessor arrayProcessor = counter(5);
        System.out.println(arrayProcessor.apply(b));

    }
}