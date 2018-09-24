package com.ma.sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 冒泡排序
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
public class Bubble {
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i-1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j +1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,5,8,4,7,6,9};
        sort(array);
        for(int a : array){
            System.out.print(a+" ");
        }
    }
}

