package com.bryantchang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * class: LeetCode3
 *
 * @author: bryantchang
 * @date: 2020/11/13
 * @description: TODO
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> charSet = new HashSet<>();
        int maxLength = 1;
        int begin = 0;
        int end = 0;
        while (begin < s.length() && end < s.length()) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                maxLength = Math.max(end - begin + 1, maxLength);
                end++;
            } else {
                charSet.remove(s.charAt(begin));
                begin++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

    }
}

