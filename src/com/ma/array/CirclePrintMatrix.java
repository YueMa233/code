package com.ma.array;

/**
 * 题目
 * 给定一个整型矩阵 matrix ,请按照转圈的方式打印它。
 *
 * 例如：
 * 1     2     3      4
 *
 * 5     6     7      8
 *
 * 9     10    11     12
 *
 * 13   14     15     16
 *
 * 打印结果为：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10。
 *
 * 解答：
 * 这里介绍一种矩阵处理的方式，该方式不仅可用于这道题，还适合很多其他的面试题，这就是矩阵分圈处理。
 * 在矩阵中左上角的坐标（tR,tC）和右下脚的坐标（dR,dC）就可以表示 一个子矩阵，比如，题目中的矩阵，当（tR,tC）= (0,0)、(dR,dC) = （3,3）时，表示的子矩阵就是整个矩阵，那么这个矩阵的最外层就是：
 *
 * 1    2    3    4
 *
 * 5               8
 *
 * 9              12
 *
 * 13  14  1 5    16
 *
 * 打印出来的结果为：1,2,3,4,8,12,16,15,14,13,9,5。接下来令tR和tC加1，即（tR,tC）=（1,1）令dR和dC减1，即（dR,dC）=(2,2)，此时表示的矩阵为：
 *
 * 6    7
 *
 * 10  11
 *
 * 打印出来为：6,7,11,10。
 * 重复如上操作。
 * 如果发现左上角的坐标跑到右下角坐标的右方或是下方，整个过程结束。
 */
public class CirclePrintMatrix {
    public static void spiralOrderPrint(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR <= dR && tC <= dC){
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    public static  void printEdge(int[][] matrix, int tR, int tC, int dR, int dC){
        //只有一行
        if(tR == dR){
            for(int i = tC; i <= dC; i++){
                System.out.print(matrix[tR][i] +" ");
            }
            //只有一列
        }else if(tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        }else{//一般情况
            int curC = tC;
            int curR = tR;
            while(curC != dC){
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }
            while(curR!= dR){
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }
            while(curC != tC){
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            while (curR != tR){
                System.out.print(matrix[curR][tC] + " ");
                curR--;
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrderPrint(matrix);

    }
}
