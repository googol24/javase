package com.googol24.java.alg.sort;

public class QuickSort {
    private static int[] arr = {
            23, 15, 43, 25, 54, 2, 6, 82, 11, 5, 21, 32, 255, 65, 25
    };

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    // 快速排序
    private static void quickSort(int[] arr, int startPos, int endPos) {
        if (startPos >= endPos)  return;
        int left = startPos;
        int right = endPos;
        // 待排序的第一个元素作为基准值
        int key = arr[left];
        // 从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                // 从右往左扫描，找到第一个比基准值小的元素
                right--;
            }
            // 找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                // 从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            // 找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        // 基准值归位
        arr[left] = key;
        // 对基准值左边的元素进行递归排序
        quickSort(arr, startPos, left - 1);
        // 对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, endPos);
    }
}
