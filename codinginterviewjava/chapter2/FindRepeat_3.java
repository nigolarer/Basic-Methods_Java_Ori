package codinginterviewjava.chapter2;

/**
 * @author nigolarer
 * 找出数组中重复的数字，满足以下条件：
 * 1.长度为n
 * 2.数组内的数字大小均在0~n-1之间
 * 3.找到任意重复数字即可停止
 *
 * 思路：
 * 最简单的就是先排序，然后前后数字比较，不相等则向后滑动继续比较直到完成
 * 降低时间复杂度为: O(n) 空间复杂度为:O(1)
 * 从前到后遍历一边数组,如果元素与自己的值不等,则将元素与自己的值所指位置的元素交换,交
 * 换前判断该位置的原元素是否已经对应自己的位置,如果已经对应了自己的位置,那么证明该元素
 * 重复,结束判断
 *
 *
 *
 *
 * */
public class FindRepeat_3 {
    public static void main(String[] args) {
        int[] c = {2, 2, 3, 4, 1, 5, 6};
        int r = findRepeat_WrongMethod(c);
        int r2 = findRepeat(c);
        System.out.println("repeat num is "+r2);
        System.out.println("repeat num is "+r);
    }
    /**
    * 关于while的说明,这里while的循环结束条件有两种
    * 1.发现重复元素,内部return
    * 2.这个需要注意,如果没有重复元素,且没有值为i的元素,是否会死循环?
    *   确实会,但是注意题设:长度为n,元素范围是0~n-1那么只会有两种情况了:
    *   a.有重复 ;
    *   b.没重复,且每个元素有出现且只出现一次.这就保障了不会出现所谓没有
    *     i元素且没有重复元素的情况,当然了,如果代码中加长度和非法值判断
    *     才能从代码层面杜绝死循环
    *
    * */
    private static int findRepeat(int[] c) {
        for (int i = 0; i < c.length; i ++) {
            while (c[i] != i) {
                if (c[i] != c[c[i]]) {
                    swap(c, i, c[i]);
                } else {
                    return c[i];
                }
            }
        }
        return -1;
    }

    /**
    * !!!!错误的方法!!!!
    * 错误的原因在于:
    * 本以为遍历一遍可以保证每一个元素都被扫描到,且交换到自己正确的位置上,但是
    * 由于前面交换的时候会将后面的元素交换到前面,后面这个元素就放置在错误的位置
    * 且再也不会被遍历到 如:1 6 2 3 4 5 6 第一次i==0交换1和6,以后i==1,再也不
    * 会判断到第一个6是否重复了
    *
    * */
    private static int findRepeat_WrongMethod(int[] c) {
        for (int i  = 0;i<c.length;i++) {
            if (i != c[i]) {
                if (c[c[i]] == c[i]) {
                    return c[i];
                }
                else{
                    swap(c,i, c[i]);
                }
            }
        }
        return -1;
    }

    private static void swap(int[] c, int i1, int i2) {
        int tmp;
        tmp = c[i1];
        c[i1] = c[i2];
        c[i2] = tmp;
    }
}
