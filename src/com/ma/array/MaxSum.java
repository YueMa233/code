package com.ma.array;

/**
 * 题目：
 * 给定一个数组arr,返回子数组的最大累加和
 */
public class MaxSum {
    public static int maxSum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i != arr.length; i++){
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,-2,3,5,-2,6,-1};
        System.out.println(maxSum(arr));
    }
}
