package com.googol24.java.array;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        // 打印数组
        int a[] = {4, 6, 8, 1, 0, 3, 9, 7, 2, 5};
        printArray(a);

        // 把输入参数存入数组，再排序
        int argsLength = args.length;
        int b[] = new int[argsLength];
        for (int i = 0; i < argsLength; i++) {
            b[i] = Integer.parseInt(args[i]);
        }

        System.out.print("b: ");
        printArray(b);

        // 排序
//        Arrays.sort(b);
//        b = bubbleSort(b);
        selectSort(b);

        System.out.print("sorted b: ");
        printArray(b);

        // 二分查找
        System.out.println("7的位置：" + Practice.binarySearch(b, 0, b.length-1, 7));
        System.out.println("5的位置：" + Practice.binarySearch(b,  5));

        // 日期数组
        Date[] dates = new Date[5];
        dates[0] = new Date(2006, 5, 4);
        dates[1] = new Date(2006, 7, 4);
        dates[2] = new Date(2008, 5, 4);
        dates[3] = new Date(2004, 5, 9);
        dates[4] = new Date(2004, 5, 4);
        System.out.println("dates:");
        printArray(dates);
        System.out.println("sorted dates:");
        printArray(bubbleSort(dates));
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void printArray(Date[] dates) {
        for (Date date : dates) {
            System.out.println(date);
        }
    }

    // 冒泡排序
    private static int[] bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        return a;
    }

    // 选择排序
    private static void selectSort(int[] a) {
        int min, temp;

        for (int i = 0; i < a.length; i++) {
            min = i;// 本次循环最小值元素的下标
            for (int j = min + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }

            if (min != i) {
                temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    public static Date[] bubbleSort(Date[] dates) {
        int length = dates.length;

        /*for (int i = length - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (dates[j].compare(dates[j + 1]) > 0) {
                    Date temp = dates[j];
                    dates[j] = dates[j + 1];
                    dates[j + 1] = temp;
                }
            }
        }*/

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (dates[i].compare(dates[j]) > 0) { // date[i] > date[j]
                    Date temp = dates[i];
                    dates[i] = dates[j];
                    dates[j] = temp;
                }
            }
        }

        return dates;
    }

    /**
     * 有序数组的二分查找算法(递归)
     *
     * @param arr int[]
     * @param start int
     * @param end int
     * @param key int
     *
     * @return int
     */
    public static int binarySearch(int[] arr, int start, int end, int key) {
        int middle = (start + end) / 2;
        if (arr[middle] == key) {
            return middle;
        } else if (arr[middle] > key) {
            return binarySearch(arr, start, middle - 1, key);
        } else {
            return binarySearch(arr, middle + 1, end, key);
        }
    }

    /**
     * 有序数组的二分查找算法（非递归）
     *
     * @param arr int[]
     * @param key int
     *
     * @return int
     */
    public static int binarySearch(int[] arr, int key) {
        if (arr.length <= 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }
}
