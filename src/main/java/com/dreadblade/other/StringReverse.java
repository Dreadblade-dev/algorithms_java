package com.dreadblade.other;

/**
 * @author Dreadblade- (https://github.com/Dreadblade-dev)
 */

public class StringReverse {
    public static String reverse(String str) {
        if (str == null || str.length() == 0)
            return str;

        char[] array = str.toCharArray();

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return String.valueOf(array);
    }
}
