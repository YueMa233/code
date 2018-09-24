package com.ma.sort;
/**
 * 插入排序
 * 通常人们整理桥牌的方法是一张一张来，将每一张排插入到其余已有牌的适当位置。
 * 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位，这种算法
 * 叫做插入排序。
 */
/**
 * 时间复杂度：O(n²)
 */

/**
 * 空间复杂度：O(1)
 */

/**
 * 稳定
 */
public class Insertionsort {
    public static void sort(int[] a){
        int N = a.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && a[j] < a[j -1]; j--){
                int tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3,2,5,8,4,7,6,9};
        sort(a);
        for(int i : a){
            System.out.print(i + " ");
        }
    }
}
