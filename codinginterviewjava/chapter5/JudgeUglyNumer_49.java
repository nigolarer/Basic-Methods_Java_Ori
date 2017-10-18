package codinginterviewjava.chapter5;

import java.util.Scanner;
/**
 * 丑数问题:
 * 1.判断一个数是不是丑数
 *
 * 2.输出第n个丑数
 *
 * 丑数,因子只有2,3,5的数,比如6,而14=2*7是有7,则不是
 * */
public class JudgeUglyNumer_49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(n+"is ugly number?"+judgeUglyNumber(n));

        System.out.println("第"+n+"个丑数是:"+getTheUglyNum(n));


    }
    /**
     * 判断一个数是不是丑数
     * 用这个数分别对2,3,5除,如果分别除了一遍之后得到的数是1则说明是丑数
     * 如:12%2 = 0 -> 12/2 6/2 ->3
     *    3%3 = 0  ->3/3 ->1
     *    1%5 != 0
     *    1==1
     *    返回true
     * */
    private static boolean judgeUglyNumber(int num) {
        boolean  isUglyNumber= false;
        while (num % 2 == 0) {
            num = num/2;
        }
        while (num % 3 == 0) {
            num = num/3;
        }
        while (num % 5 == 0) {
            num = num/5;
        }
        if (num == 1) {
            isUglyNumber = true;
        }
        return isUglyNumber;
    }
    /**
     * 功能:获得第num个丑数
     * 1.首先将每个丑数都熟顺序的记录下来存放在辅助数组中,根据这个顺序来计算下一个丑数并保存在这个数组中
     * 2.分别定义3个辅助指针,用来根据丑数数组分别生成2,3,5的倍数(由于是根据前面的丑数生成的,所以生成的
     * 新数依然是丑数)
     * 3.3个辅助指针都是从第0位开始判断,并自增,一直自增到它乘自己指针代表的倍数后刚好大于当前最大的丑数
     *  为止.比如,丑数数组为,1,2,3,4,5,6,8,10当前最大丑数是10,对于2倍指针来说,他指到6时,6*2==12刚好
     *  是12大于10;对于3倍指针,它指到4时,4*3==12大于10;5倍指针指到3时,3*5==15,恰好刚大于10
     * 4.此时,根据3.的结果就可以生成下一位丑数了,从3.中找到最小的赋给下一位即可.如10的下一位,由于有
     *  12,12,15,那么下一位就是12.如此循环,next++指到next到达num时为止
     *
     * 注意,打印的时候由于while循环跳出条件是next>num(即next==num跳出),所以打印要next-1,否则越界
     *
     * */
    private static int getTheUglyNum(int num) {
        int[] uglyNumber = new int[num];
        uglyNumber[0] = 1;
        int next = 1;
        int uglyNum2 = 0;
        int uglyNum3 = 0;
        int uglyNum5 = 0;

        while (next < num) {
            uglyNumber[next] = min(uglyNumber[uglyNum2]*2, uglyNumber[uglyNum3]*3, uglyNumber[uglyNum5]*5);
            while (uglyNumber[uglyNum2] * 2 <= uglyNumber[next]) {
                uglyNum2++;
            }
            while (uglyNumber[uglyNum3] * 3 <= uglyNumber[next]) {
                uglyNum3++;
            }
            while (uglyNumber[uglyNum5] * 5 <= uglyNumber[next]) {
                uglyNum5++;
            }
            next++;

        }
        return uglyNumber[next - 1];

    }
    /**
     * 3个数比较大小
     * 注意这个3个数比较大小的写法
     * */
    private static int min(int i, int i1, int i2) {
        int min;
        min = i > i1 ? i1 : i;
        return min > i2 ? i2 : min;
    }
}
