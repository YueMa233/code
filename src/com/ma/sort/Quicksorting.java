package com.ma.sort;
/**
 * 快速排序
 * 快速排序（英语：Quicksort），又稱劃分交換排序（partition-exchange sort），簡稱快排，一種排序算法，最早由
 * 東尼·霍爾提出。在平均狀況下，排序  n個項目要  O(n\log n)
 *  O(n\log n)大O符号）次比較。在最壞狀況下則需要 O(n^{2})
 * O(n^{2})次比較，但這種狀況並不常見。事實上，快速排序 Theta (n\log n)
 * Theta (n\log n)通常明顯比其他演算法更快，因為它的內部循环（inner loop）可以在大部分的架構上很有效率地達成。
 */
/**
 * 时间复杂度：O(nlog2n)
 */

/**
 * 空间复杂度：O(1)
 */

/**
 * 不稳定
 */

public class Quicksorting {
    public static void quickSort(int[] a, int low, int hi){
        if(low < hi){
            int middle = getMiddle(a, low, hi);
            quickSort(a, 0, middle - 1);
            quickSort(a, middle + 1, hi);
        }
    }
    public static int getMiddle(int[] a, int low, int hi){
        int key = a[low];
        while(low < hi){
            while(low <hi && a[hi] >= key){
                hi--;
            }
            a[low] = a[hi];
            while(low < hi && a[low] <= key){
                low++;
            }
            a[hi] = a[low];
        }
        a[low] = key;
        return low;
    }
    public static void main(String[] args) {
        int[] a = {3,2,5,8,4,7,6,9};
        quickSort(a, 0, a.length - 1);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
