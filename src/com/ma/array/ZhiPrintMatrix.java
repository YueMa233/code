package com.ma.array;

/**
 * 题目：
 * 给定一个矩阵matrix，按照“之”字形打印这个矩阵，例如：
 * 1     2     3     4
 * 5     6     7     8
 * 9    10    11    12
 * “之”字形打印结果为：1,2,5,9,6,3,4,7,10,11,8,12。
 *
 * 解答：
 * 1、上坐标（tR,tC）初始为（0,0），先沿矩阵第一行移动（tC++）,当到达第一行最右边的元素时，再沿着矩阵
 * 最后一列移动
 * （tR++）。
 * 2、下坐标（dR,dC）初始时为（0，0），先沿矩阵第一列移动（dR++）,当到达第一列最下边元素的时候再沿着
 * 矩阵最后一行移动（dC++）。
 * 3、上坐标与下坐标同时移动，每次移动后的上坐标与下坐标的连线就是矩阵的一条斜线，打印斜线上的元素即可。
 * 4、如果上次斜线是从左下向右上打印的，这次一定是从右上向左下打印的，反之亦然。将打印的方向取
 * Boolean值，每次取反。
 */
public class ZhiPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while(tR != endR +1){
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
    }
    public static void printLevel(int[][] matrix,int tR, int tC, int dR, int dC, boolean f){
        if(f){
            while(tR != dR + 1){
                System.out.print(matrix[tR++][tC--] + " ");
            }
        }else{
            while(dR != tR - 1){
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrixZigZag(matrix);
    }
}
