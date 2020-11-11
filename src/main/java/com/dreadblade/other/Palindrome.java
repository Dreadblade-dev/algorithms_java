package com.dreadblade.other;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();

        for (int i = 0, k = str.length() - 1; i < k; i++, k--) {
            if (str.charAt(i) != str.charAt(k))
                return false;
        }

        return true;
    }
}
