package com.ma.array;

/**
 * 题目
 * 给定一个N×M的矩阵 matrix，把这个矩阵调整为顺时针转动90°后的形式。
 *
 * 例如：
 * 1      2      3     4
 * 5      6      7     8
 * 9     10    11   12
 * 13   14    15   16
 *
 * 顺时针转动90°后为：
 * 13     9     5    1
 * 14    10    6    2
 * 15    11    7    3
 * 16    12    8    4
 *
 * 解答:
 * 这里仍使用分圈处理的方法，在矩阵中用左上角的坐标（tR,tC）和右下角的坐标（dR,dC）就可以表示一个子矩阵。比如题目中的矩阵，当（tR,tC）= (0,0)、（dR,dC）= (3,3)时表示的子矩阵就是整个矩阵，那么这个子矩阵最外层的部分就是：
 *
 * 1     2     3     4
 * 5                   8
 * 9                  12
 * 13  14   15   16
 *
 * 在这外圈中1,4,16,13为一组，然后让1占据4的位置，4占据16的位置，16占据13的位置，13占据1的位置，一组就
 * 调整完了。然后2,8,15,9为一组，最后3,12,14,5为一组，继续上面的过程。然后（tR,tC）=（0,0）、
 * （dR,dC）=（3,3）的子矩阵外层就调整完毕。接下来令tR和tC加1，即（tR,tC）=（1,1），令dR,dC减1即
 * （dR,dC）=（2,2），
 * 此时表示的矩阵为：
 *
 *  6      7
 * 10    11
 * 方法同上。
 */

public class RotatePrintMatrix {
    public static void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while(tR < dR){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    public static void rotateEdge(int[][] matrix,int tR,int tC,int dR, int dC){
        int times = dC - tC;//times是总的组数
        int tmp = 0;
        for(int i = 0; i != times; i++){//一次循环就是一组占据的调整
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
