package com.liemartt.pr_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Function function = o -> {
            String[] newArray = new String[((String[]) o).length];
            int pos = 0;
            for (String x : (String[]) o) {
                newArray[pos++] = new StringBuilder(x).reverse().toString();
            }
            return newArray;
        };
        String[] arr = {"123", "hello", "qwerty123"};
        String[] newArr = (String[]) function.apply(arr);
        System.out.println(Arrays.toString(newArr));
    }
}
