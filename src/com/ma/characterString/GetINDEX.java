package com.ma.characterString;

/**
 * 题目：
 * 给定一个字符串数组strs[],在strs中有些位置为null,但在不为null的位置上，其字符串是按照字典顺序有小到大依次出现的。
 * 再给定一个字符串str返回str在strs中出现的最左的位置。
 *
 * 举例：
 * strs=[null,"a",null,"a",null,"b",null,"c"],str="a",返回1。
 * strs=[nulll,"a",null,"a",null],str="d",返回-1。
 *
 * 解答：
 *
 * 1.假设在strs[left...right]上进行查找的过程，全局整型变量res表示字符串str在strs中出现最左的位置。初始时，left=0，right=strs.length-1，res=-1。
 *
 * 2，令mid=（left+right）/2,则strs[mid]为strs[left...right]中间的字符串。
 *
 * 3.如果字符串strs[mid]与str 一样，说明找到了str令res=mid。但是要找的是最左的位置，所以还要在左半区查找，看有没有更左的str出现，所以令right=mid-1，重复步骤2。
 *
 * 4.如果字符串strs[mid]与str不一样，但是strs[mid]!=null,此时可以比较strs[mid]和str的大小，如果strs[mid]的字典顺序比str小那么说明在strs[mid+1,right]可能会存在str。进行步骤2。
 *
 * 5.如果字符串strs[mid]与str不一样，并且strs[mid]==null，此时从mid开始，从右到左遍历左半区。如果整个左半区都为null，那么遍历右半区用二分法，重复步骤2。如果整个左半区不全为null，假设遍历左半区时候发现第一个不为null的位置记做i,那么把strs[i]与str比较，如果str[i]小于str说明左半区不会出现，令left=mid+1。重复步骤2。如果找见，继续找左边。
 * 右边与之相同。
 */
public class GetINDEX {
    public static int getIndex(String[] strs, String str){
        if(strs == null || strs.length == 0 || str == null){
            return -1;
        }
        int res =-1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while(left <= right){
            mid = (left + right) /2;
            if(strs[mid] != null && strs[mid].equals(str)){
                res = mid;
                right = mid -1;
            }else if(strs[mid] != null){
                if(strs[mid].compareTo(str) < 0){
                    left = mid + 1;
                }else{
                    right = mid +1;
                }
            }else{
                i = mid;
                while(strs[i] == null && --i >= left)
                    ;
                if(i < left || strs[i].compareTo(str) < 0){
                    left = mid +1;
                }else{
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs  = {null,"a",null, "a",null,"b"};
        String str = new String("a");
        int i = getIndex(strs, str);
        System.out.println(i);
    }
}
