package intv.method.Dynamic;

import java.util.Scanner;
/*
* 动态规划,计算一个三角形从顶点走向底边的最大值是多少,每次只能走左下或者右下的点
* 如:
* 1                                              1
* 23                                           2   3
* 456                                        4   5   6
* 此时,1可以走2或者3,2可以走4或者5
*最大值为1->3->6 = 10
*
* 第一行输入三角形的高,之后依次输入每个点的值
* */
public class DynamicTriangleTest {
    static int max_num;
    static int a[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        max_num = scan.nextInt();
        a = new int[max_num][max_num];
        for(int i = 0;i<a[0].length;i++) {
            for(int j = 0;j<i;j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int sum = doDynamicTriangleSum(a,0,0);
        showTriangle(a);
        System.out.println("sum = "+sum);
    }

    private static void showTriangle(int[][] a) {
        for(int i = 0;i<a[0].length;i++) {
            for(int j = 0;j<i;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int doDynamicTriangleSum(int[][] a, int i, int j) {
        System.out.println("in func "+"i = "+i+" j = "+j);
        if (i == max_num-1) {
            System.out.println("i to btm return a["+i+"]["+j+"] = "+a[i][j]);
            return a[i][j];
        }
        int x = doDynamicTriangleSum(a, i + 1, j);
        int y = doDynamicTriangleSum(a, i + 1, j + 1);
        System.out.println("x = "+x+" y = "+y+" max is "+ max(x,y)+" a["+i+"]["+j+"] = "+a[i][j]);
        return max(x, y) + a[i][j];

    }

    private static int max(int x, int y) {
        int z = x>y?x:y;
        return z;
    }
}
