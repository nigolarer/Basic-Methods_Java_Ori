package codinginterviewjava.chapter5;

import java.util.Scanner;
/**
 * 打印第一个不重复的字符
 * 1.看到这个问题首先想到的是读取字符,向后比对,如果没有重复则是第一个,返回,如果后面重复则比较下一个.O(n^2)
 *
 * 另一种方法:
 * Hash对应关系.
 * 1.初始化:每一个字符对应一个数值,建立字符库的哈希表,初始都为0,ASCII的字符集是256,所以定义固定长度辅助空间
 * 2.第一遍扫描字符串的时候对应hash数组中的位置自增O(n)
 * 3.第二遍扫描字符串的时候对比hash数组中的值,如果等于1则返回当前扫描到的字符
 *
 * */
public class FirstNoRepeatChar_50 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char[] sc = s.toCharArray();
        char firstChar = getFirstNoRepeatChar(sc);
        System.out.println(firstChar);
    }

    /**
     * 建立hash数组
     * 第一次扫描字符串s的时候对应hash数组位置自增
     * 第二次扫描字符串s的时候查找对应的hash数组值,是1则返回字符
     *
     * */
    private static char getFirstNoRepeatChar(char[] s) {
        int [] hashT = new int[256];
        for (char iter : s) {
            hashT[iter]++;
        }
        //printCharList(hashT);
        for (char iter : s) {
            if (hashT[iter] == 1) {
                return iter;
            }
        }
        return '\0';
    }
    /**
     * 测试打印字符数组用
     * */
    private static void printCharList(char[] s) {
        for (char ch : s) {
            System.out.print(ch+" ");
        }
        System.out.println();
    }
    /**
     * 测试打印int数组用
     *
     * */
    private static void printCharList(int[] s) {
        for (int ch : s) {
            System.out.print(ch+" ");
        }
        System.out.println();
    }
}
