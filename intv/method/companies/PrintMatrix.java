package intv.method.companies;
/**
 * @author nigolarer
 * 有一个矩阵:
 *  1  2   3  4
 *  5  6   7  8
 *  9  10 11 12
 * 13  14 15 16
 * 打印如下:
 * 1
 * 2 5
 * 3 6 9
 * 4 7 10 13
 * 8 11 14
 * 12 15
 * 16
 *
 * 以及:
 * 4
 * 3 8
 * 2 7 12
 * 1 6 11 16
 * 5 10 15
 * 9 14
 * 13
 *
 *  */
public class PrintMatrix {
    public static void main(String[] args) {
        int[][]c = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};
        printMatrixTriangleClockwise(c);
        System.out.println();
    }

    private static void printMatrixTriangleClockwise(int[][] c) {
        int col = c[0].length;
        int row = c.length;
        if (c == null||row!=col) {
            return;
        }
        for(int i = 0;i < col;i++) {
            int tmprow = 0;
            for (int j = i; j >= 0; j--,tmprow++) {
                System.out.print(c[tmprow][j]+" ");
            }
            System.out.println();
        }
        for (int i = 1; i < row; i++) {
            int tmpcol = col-1;
            for (int j = i; j <row; j++,tmpcol--) {
                System.out.print(c[j][tmpcol]+" ");
            }
            System.out.println();
        }
        //System.out.println(col+" "+row);

    }


}
