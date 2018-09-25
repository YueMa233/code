package com.ma.sort;
/**
 * 归并排序
 * 要将一个数组排序可以先将它递归的分成两部分进行排序，然后将结果归并起来。
 */
/**
 * 时间复杂度：O(nlog2n)
 */

/**
 * 空间复杂度：O(n)
 */

/**
 * 稳定
 */

public class Mergesort {
    private static int[] ca;//归并时候需要的辅助数组
    public static void sort(int[] a){
        ca = new int[a.length];
        sort(a,0,a.length - 1);
    }
    private static void sort(int[] a, int lo, int hi){
        //将数组a[lo...hi]排序
        if(hi <= lo){
            return;
        }
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);//将左半边排序
        sort(a,mid + 1, hi);//将右半边排序
        merge(a, lo, mid, hi);
    }
    public static void merge(int[] a,int lo, int mid, int hi){
        //将a[lo...mid]和a[mid+1...hi]归并
        int i = lo,j = mid + 1;
        for(int k = lo; k <= hi; k++){
            ca[k] = a[k];
        }
        for(int k = lo; k <= hi; k++){
            if(i > mid) a[k] = ca[j++];
            if(j > hi) a[k] = ca[i++];
            else if(ca[j] < ca[i]) a[k] = ca[j++];
            else a[k] = ca[i++];
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
