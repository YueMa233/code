package com.ma.array;

/**
 * 题目：
 * 给定一个无序数组arr，求出需要排序的最短数组长度。
 * 例如：
 * arr=[1,5,3,4,2,6,7]返回4，因为只有[5,3,4,2]需要排序。
 *
 * 解答：
 * 初始化变量noMinIndex=-1,从右向左遍历，遍历的过程中记录右侧出现的数的最小值，记作min。假设当前数为arr[i],如果arr[i]>min,说明如果要整体有序，min值必然会移到arr[i]的左边。用noMinIndex记录最左边出现这种情况的位置。如果遍历完成后noMinIndex依然为-1，说明从右到左始终不升序，原数组本来就有序，直接返回0。
 * 接下来从左到右遍历，遍历的过程中记录左侧出现的最大值，记作max。假设当前数为arr[i],如果arr[i]<max,说明如果排序，max值必然会挪到arr[i]的右边。用变量noMaxIndex记录最右边出现这种情况的位置。
 * 遍历完成后，arr[noMinIndex...noMaxIndex]是真正需要排序的部分，返回它的长度即可。
 */
public class GetMInLength {
    public static int getMinLength(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for(int i = arr.length - 2; i != -1 ; i--){
            if(arr[i] > min){
                noMinIndex = i;
            }else{
                min = Math.min(min, arr[i]);
            }
        }
        if(noMinIndex == -1){
            return 0;
        }
        int max = arr[0];
        int noMaxIndex = -1;
        for(int i = 1; i != arr.length; i++){
            if(arr[i] < max){
                noMaxIndex = i;
            }else{
                max = Math.max(max,arr[i]);
            }
        }
        return noMaxIndex - noMinIndex +1;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2,6,7};
        System.out.println(getMinLength(arr));
    }
}
