package com.bryantchang.leetcode;

/**
 * class: LeetCode4
 *
 * @author: bryantchang
 * @date: 2020/11/13
 * @description: TODO
 */
public class LeetCode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthL = nums1.length;
        int lengthR = nums2.length;
        int totalLength = lengthL + lengthR;
        int left = (totalLength + 1) / 2;
        int right = (totalLength + 2) / 2;
        return (getKth(nums1, 0, lengthL - 1, nums2, 0, lengthR - 1, left) + getKth(nums1, 0, lengthL - 1, nums2, 0, lengthR - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if (length1 > length2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (length1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(length1, k / 2) - 1;
        int j = start2 + Math.min(length2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1};
        int[] nums2 = {2, 3, 4, 5};
        System.out.println(new LeetCode4().findMedianSortedArrays(nums1, nums2));
    }
}
