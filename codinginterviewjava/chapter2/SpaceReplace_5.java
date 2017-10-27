package codinginterviewjava.chapter2;

import java.util.Scanner;

/**
 * @author nigolarer
 * 替换字符串中的空格为指定的字符串
 * 如:1 2 3 -->  1%202%203
 * 思路是:
 * 1.扫描字符串长度,并计算空格个数
 * 2.申请新字符串的长度(空格的长度变成新串长度)并将原字符串的字符从后向前复制到新串中
 * 3.如果遇到了空格,则替换成指定的字符串
 *
 * */
public class SpaceReplace_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StringBuffer s = new StringBuffer().append(str);
        char[] rep = scan.next().toCharArray();
        replaceSpace(s, rep);

        System.out.println(s);


    }
    /**
     * 屎一样的代码,总算是实现了功能,主要是i,j,charAt等实在是太乱了
     * 1.计算空格个数,修改字符串长度(所以用了StringBuffer)
     * 2.从后向前在原字符串上复制
     * 3.遇到空格,则将替换字符串复制到新位置上,并修改对应关系i,这个修改对应关系比较繁琐
     * */
    private static void replaceSpace(StringBuffer s, char[] rep) {
        int len = s.length();
        int scount = 0;
        //计算space 的个数
        for (int i = 0;i<len;i++) {
            if (s.charAt(i) == ' ') {
                scount++;
            }
        }
        //计算并设置新字符串长度
        int newLen = len+scount*(rep.length-1);
        s.setLength(newLen);
        /* 新长度从最后一位向前对应着旧的字符串最后一位扫描:
         * 如果不是空格直接将旧的字符复制到对应位置:
         * 1.对应的位置=原字符位置+替换字符串的个数x(替换字符串的大小-1)
         *  注:空格也是1位,所以替换的字符串大小-1才是正确的
         * 如果是空格:
         * 1.原字符串映射位置=s.charAt(i - scount * (rep.length - 1))
         *   i是新的字符串当前的位置,scount*(rep.length - 1)是空格替成新字
         *   符的大小.
         *   例如:原串只有一个空格,替换成aa,那么i=1,scount*(rep.len-1)=> 1x(2-1)=1
         *   得出原串空格位置是0
         * 2.内层for循环为新串增加替换子字符串,并且由于替换n个字符,i需要减n,但是,由于
         *   外层for循环还是会自动i减一,所以,替换完成后还需要加一,这里写的真是屎
         *   例如,只有一个空格,替换成3个字符,i-3,而外层循环会再减1次,变成了i-4.
         *   换句话说,由于i开始指向的就是最后一个替换后的字符位置,少减2次刚好替换完成,
         *   外层再减1,比较空格前一位的字符.
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i - scount * (rep.length - 1)) == ' ') {
                for (int j = rep.length - 1; j >= 0; j--) {
                    s.replace(i, i + 1, String.valueOf(rep[j]));
                    i--;
                }
                //傻x的i++,外层换成while循环会更清楚
                i++;
                scount--;
            } else {
                s.replace(i, i + 1, String.valueOf(s.charAt(i - scount * (rep.length - 1))));
            }
            //打印测试
            //System.out.println("s="+s+" i="+i);
        }
    }
}
