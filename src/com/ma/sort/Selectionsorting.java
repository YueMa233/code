package com.ma.sort;

/**
 * 选择排序
 * 一种最简单的排序方法，首先，找到数组中最小的元素，其次，将它和数组第一个元素交换位置。
 * 再次，在剩下的元素中找到最小的元素和第二个位置的元素进行交换。
 */

/**
 * 时间复杂度：O(n²)
 */

/**
 * 空间复杂度：O(1)
 */

/**
 * 不稳定
 */
public class Selectionsorting {
    public static void sort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i +1; j < a.length; j++){
                if(a[j] < a[i]){
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {3,2,5,8,4,7,6,9};
        sort(a);
        for (int i : a){
            System.out.print(i+" ");
        }
    }
}
