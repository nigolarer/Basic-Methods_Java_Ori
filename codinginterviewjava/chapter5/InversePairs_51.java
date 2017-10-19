package codinginterviewjava.chapter5;

import java.util.Scanner;

/**
 * 数组中的逆序对问题
 * 所谓逆序对是线性代数中计算行列式的(-1)^n时使用的,那里是计算逆序数,即逆序对的总数
 * 如:7564 7后面比7小的数字有3个,(7,5)就是一个逆序对,还有(7,6),(7,4)
 *         5后面比5小的数字有1个,(5,4)
 *         6后面比6小的数字有1个,(6,4)
 * 遍历是最简单的办法,分别统计或者依次打印都行,O(n^2)
 *
 * 优化:
 * 看到书上实际就是用了归并排序思想,刚好没有总结归并排序算法,这里实现一下
 * 首先,为什么可以用归并来统计逆序对呢?因为归并的核心思想就是比较交换,冒泡也可以来做逆序对
 * 的判断,只是冒泡复杂度没变而已而归并的复杂度O(nlogn)
 * 其次,怎么统计呢?很简单,如果归并的时候交换了,交换几次就说明有几个逆序对
 * 最后,问题就回到最原始的归并排序的实现上.
 *
 * 归并排序首先需要需要额外的O(n)空间,最终排序好的数组就是在这个额外的空间上,而不是原数组上.
 *
 *
 *
 * */
public class InversePairs_51 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] cs = s.toCharArray();
        char[] cs2= s.toCharArray();
        for (char iter : cs) {
            System.out.print(iter+" ");
        }
        System.out.println();
        int count = InversePairCore(cs, cs2,0,cs.length-1);
        System.out.println("count = "+count);
        for (char iter : cs2) {
            System.out.print(iter+" ");
        }
    }

    private static int InversePairCore(char[] data, char[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0; 
        }
        int length = (end - start) / 2;
        /*
        * 请注意,这里入参的顺序是不一样的,copy和data位置互换了
        * 这里是为了用两个数组分别存储的做每一趟排序的结果,
        * 而总之递归到最顶层的时候,仍然是copy数组中存放最终
        * 排序结果
        *
        * */
        int left = InversePairCore(copy, data, start, start + length);
        int right = InversePairCore(copy, data, start + length + 1, end);
        //i指向分组后的第一组最后一个元素
        int i = start + length;
        //j指向分组后的第二组最后一个元素
        int j = end;
        //indexCopy指向辅助空间里两组即将合并后最后一个位置
        int indexCopy = end;
        //count计算逆序对的数目
        int count = 0;
        /*
        * 将两个(各自有序的)数组分别从最大的元素向前合并到copy数组中.
        * 其中,如果是第1个数组的元素大于第二个数组中的某个元素,
        * 那么第1个数组中的这个元素一定大于第二个数组中那个元素之前的所有元素
        *
        * 这里注意一下,每次len/2的时候,接下来分割成left和right进入递归这里的left和
        * right就转换了data和copy的位置,他们和上一层是相反的.而他们各自的下一层和他们这一层
        * 又是相反的,所以同一层之间是相同的,与上一层是相反的.
        * */
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j-start-length;
            } else {
                copy[indexCopy--] = data[j--];
            }

        }
        /*
        * 当某个数组的元素已经全部复制到辅助数组,而另一个数组还没有全部复制完的时候,剩余元素全部复制
        *
        */
        for(;i>=start;--i) {
            copy[indexCopy--] = data[i];
        }
        for(;j>=start+length+1;--j) {
            copy[indexCopy--] = data[j];
        }
        return left+right+count;
    }
}
