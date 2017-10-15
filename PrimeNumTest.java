/*
* 素数
* Fun2是改进版本求素数的方法:
* 这里外循环的i从3开始,每次加2,因为偶数一定不是素数
* 内循环j从2到根号i分别计算
* 为什么是根号:比如24 = 1*24 2*12....4*6,接下来就是根号24*根号24 再接下来就是 6*4 8*3
* 所以只要判断到根号24,如果之后还是有的话即6*4,而4*6和6*4结果一样,没有必要再判断6*4了
*
* 如果判断到根号i与j相等,那么说明之前没有数字可以相乘得到了,所以就认为i是素数
* 这里注意到根号i强制转化成了整形,其实不影响判断
* */
public class PrimeNumTest {
    public static void main(String[] args) {
       //System.out.println(Math.sqrt(10));
        //Func1();
        Func2();

    }

    private static void Func2() {
        int a = 100;
        int j ;
        for (int i = 3; i < a; i+=2) {
            j = 2;
            for(;j<(int)Math.sqrt(i);j++) {
                //System.out.println(""+i%j);
                if (i % j == 0) {
                    break;
                }
               // System.out.println(" "+(int)Math.sqrt(i));
            }
            if ((int)Math.sqrt(i) == j) {
                System.out.print(""+i+" ");
            }
        }

    }
    private static void Func1() {
        int a = 200;
        for(int i = 3 ;i<200;i++) {
            int j = 2;
            for(;j< i;j++) {
                if (i % j == 0) {
                  break;
                }
            }
            if (j == i) {
                System.out.println(""+i);
           }
        }
    }
}
