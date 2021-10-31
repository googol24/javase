package com.googol24.java.alg.sort;

import java.util.*;

/**
 * 常见排序方法
 *
 * 冒泡排序
 * 快速排序
 * 插入排序
 * 希尔排序
 * 选择排序
 * 归并排序
 * 堆排序
 * 基数排序
 */
public class SimpleSort {

    private static int[] arr = {
            23, 15, 43, 25, 54, 2, 6, 82, 11, 5, 21, 32, 255, 65, 25
    };

    public static void main(String[] args) {
//        bubbleSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        insertSort(arr);
//        shellSort(arr);
//        selectSort(arr);
//        mergeSort(arr, 0, arr.length - 1);
//        heapSort(arr);
        radixSort(arr);

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

//    // 快速排序
//    public static void quickSort(int[] arr, int startPos, int endPos) {
//        if (startPos >= endPos) {
//            return;
//        }
//
//        int left = startPos;
//        int right = endPos;
//
//        // 待排序的第一个元素作为基准值
//        int key = arr[left];
//
//        // 从左右两边交替扫描，直到left = right
//        while (left < right) {
//            while (right > left && arr[right] >= key) {
//                // 从右往左扫描，找到第一个比基准值小的元素
//                right--;
//            }
//
//            // 找到这种元素将arr[right]放入arr[left]中
//            arr[left] = arr[right];
//
//            while (left < right && arr[left] <= key) {
//                // 从左往右扫描，找到第一个比基准值大的元素
//                left++;
//            }
//
//            // 找到这种元素将arr[left]放入arr[right]中
//            arr[right] = arr[left];
//        }
//
//        // 基准值归位
//        arr[left] = key;
//
//        // 对基准值左边的元素进行递归排序
//        quickSort(arr, startPos, left - 1);
//
//        // 对基准值右边的元素进行递归排序。
//        quickSort(arr, right + 1, endPos);
//    }

    // 直接插入排序
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 假设arr[0...i-1]已经有序
            int element = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (element < arr[j]) {
                    // 移动
                    arr[j + 1] = arr[j];
                    arr[j] = element;
                } else {
                    // 假设arr[0...i-1]已经有序，此时可以跳出循环了
                    break;
                }
            }
        }
    }

    // 希尔排序
    public static void shellSort(int[] arr) {
        // 步长
        int increment = arr.length / 2;

        while (increment > 0) {
            for (int i = increment; i < arr.length; i++) {
                int j = i;
                while (j >= increment && arr[j - increment] > arr[j]) {
                    int temp = arr[j - increment] + arr[j];
                    arr[j - increment] = temp - arr[j - increment];
                    arr[j] = temp - arr[j - increment];
                    j -= increment;
                }
            }

            increment = increment / 2;
        }
    }

    // 简单选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录第i个元素后的所有元素最小值的下标
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // swap
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // 归并排序
    public static void mergeSort(int[] arr, int startPos, int endPos) {
        if (startPos < endPos) {
            // 说明子序列内存在多余1个的元素，那么需要拆分，分别排序
            int mid = (startPos + endPos) / 2;

            // 递归排序
            mergeSort(arr, startPos, mid);
            mergeSort(arr, mid + 1, endPos);

            // 合并
            merge(arr, startPos, mid, endPos);
        }
    }

    // 两路归并
    private static void merge(int[] arr, int startPos, int mid, int endPos) {
        int[] temp = new int[arr.length];

        int p1 = startPos, p2 = mid + 1, k = startPos;// p1、p2是检测指针，k是存放指针

        while (p1 <= mid && p2 <= endPos) {
            if (arr[p1] <= arr[p2]) {
                temp[k++] = arr[p1++];
            } else {
                temp[k++] = arr[p2++];
            }
        }

        while (p1 <= mid) temp[k++] = arr[p1++];// 如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while (p2 <= endPos) temp[k++] = arr[p2++];// 同上

        // 复制回原素组 System.arrayCopy()
        for (int i = startPos; i <= endPos; i++) {
            arr[i] = temp[i];
        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {

        int size = arr.length;

        // 建立初始堆
        buildHeap(arr, size);

        // 取出堆顶的元素，其余元素继续建堆，如此往复直至堆中只有一个元素
        for (int i = arr.length - 1; i >= 1; i--) {
            // 交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 重新建堆
            buildHeap(arr, --size);
        }
    }

    // 建堆（大顶堆）
    private static void buildHeap(int[] arr, int size) {
        // 利用完全二叉树的特性，调整所有非叶节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            // 如果有左节点,将其下标存进最小值$min
            if (i * 2 + 1 < size) {
                int max = i * 2 + 1;

                // 如果有右子结点,比较左右结点的大小,如果右子结点更小,将其结点的下标记录进最大值max
                if (i * 2 + 2 < size) {
                    if (arr[i * 2 + 2] > arr[max]) {
                        max = i * 2 + 2;
                    }
                }
                // 将子结点中较大的和父结点比较,若子结点较大,与父结点交换位置,同时更新较大
                if (arr[max] > arr[i]) {
                    // swap
                    int temp = arr[max];
                    arr[max] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    // 基数排序
    private static void radixSort(int[] arr) {
        // 最大的基数
        int maxDigits = (int) Math.pow(10, getMaxDigits(arr));
        int n = 1;// 代表位数对应的数：1,10,100...
        int k = 0;// 保存每一位排序后的结果用于下一位的排序输入
        int length = arr.length;
        int[][] bucket = new int[10][length];// 排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[length];// 用于保存每个桶里有多少个数字
        while (n < maxDigits) {
            for (int num : arr) // 将数组array里的每个数字放在相应的桶里
            {
                int digit = (num / n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for (int i = 0; i < length; i++)// 将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if (order[i] != 0)// 这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶里计数器置0，用于下一次位排序
            }
            n *= 10;
            k = 0;//将k置0，用于下一轮保存位排序结果
        }

    }

    // 获取最大位数
    private static int getMaxDigits(int[] arr) {
        int maxDigits = 0;

        for (int item : arr) {
            maxDigits = Math.max(maxDigits, String.valueOf(item).length());
        }

        return maxDigits;
    }
}
