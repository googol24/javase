package com.googol24.java.alg.search;

/**
 * 对有序数组的二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {
                1, 3, 5, 7, 9, 11,
        };

        int key = 9;
//        int key = 6;

        System.out.println(binarySearch(arr, key));
    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
