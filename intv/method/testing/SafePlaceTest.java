package intv.method.testing;

import java.util.Scanner;
/*
* 防空洞问题:
* M*M的地图上有n个人和防空洞,现在让每个人进洞后求出最近方案里的最远的值
*
* input//第一行是n,表示n个人和防空洞
* 2
* 0 0   //这两行是防空洞坐标
* 0 3
*
* 0 2   //这两行是人的坐标
* 0 5
* output
* 2     //最近方案的最远值是2
*
*
* condition:2017-09-27 尚未实现功能
* */
public class SafePlaceTest {
    public static void main(String[] args) {
        int[][]a = new int[10000][10000];
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for(int i = 0;i<num;i++) {//输入防空洞坐标
            int sposX = scan.nextInt();
            int sposY = scan.nextInt();
            a[sposX][sposY] = 1;
        }
        for(int i = 0;i<num;i++) {//输入人的坐标
            int pposX = scan.nextInt();
            int pposY = scan.nextInt();
            a[pposX][pposY] = a[pposX][pposY]+2;
        }
        for(int i = 0;i<10;i++) {
            for(int j = 0;j<10;j++) {
                System.out.print(""+a[i][j]+" ");
            }
            System.out.println();
        }
        int minX = 0,minY = 0,maxMin = 0;
        for(int i = 0;i<10;i++) {
            for(int j = 0;j<10;j++) {
                if (a[i][j] == 2) {//发现了人
                    System.out.println("found human site:("+i+","+j+")");
                    for(int k = 0;i<10;i++) {
                        int min = 9999;
                        for(int l = 0;l<10;l++) {
                            if (a[k][l] == 1) {
                                if (min > Math.abs(k - i) + Math.abs(l - j)) {
                                    min = Math.abs(k - i) + Math.abs(l - j);
                                    minX = k;
                                    minY = l;
                                    System.out.println("洞-> k:"+k+" l:"+l+" 人-> i:"+i+" j:"+j);
                                    System.out.println("min"+min);

                                }

                            }
                        }
                        System.out.println("("+i+","+j+") ->"+"hole:("+minX+","+minY+")");

                        a[minX][minY] = 3;
                        a[i][j] = 0;
                        if (maxMin < min&& min != 9999) {
                            System.out.println("maxmin "+maxMin+"  min"+min);
                            maxMin = min;
                        }

                    }
                }
            }
        }
        System.out.println(maxMin);
    }
}
