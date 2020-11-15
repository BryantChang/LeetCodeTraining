package com.bryantchang.leetcode;

/**
 * class: LeetCode5
 *
 * @author: bryantchang
 * @date: 2020/11/15
 * @description: TODO
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String longestPalindrome = s.charAt(0) + "";
        if (s == null || "".equals(s)) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (j - i + 1> maxLen && isValidPalindrome(s.substring(i, j + 1))) {
                    maxLen = j - i;
                    longestPalindrome = s.substring(i, j + 1);
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isValidPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return false;
        }

        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(new LeetCode5().isValidPalindrome(s));
        System.out.println(new LeetCode5().longestPalindrome(s));
    }

}
