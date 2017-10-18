package codinginterviewjava.chapter5;

import java.util.Scanner;

/**
 * 剑指offer 50题第4个扩展问题:判断变位词(anagram)
 * 所谓变位词就是单词里面的字符个数一样就算如 silent 和 listen evil和live
 * 这里需要用到hash数组来做
 *
 * */
public class JudgeSameLetterWord_50_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println(s1 + " and " + s2 + "are anagram: " + judgeAnagram(s1.toCharArray(), s2.toCharArray()));
    }
    /**
     * 首先,创建一个hash数组,然后扫描第一个数组,对字符对应的hash位置加1
     * 其次,扫描第二个数组,对字符对应的hash位减1
     * 最后,扫描hash数组,如果不是全部为0,说明不对应.
     *
     * */
    private static boolean judgeAnagram(char[] s1, char[]s2) {
        if (s1 == null || s2 == null || s1.length != s2.length) {
            return false;
        }
        int[] hash = new int[256];
        for (char ch : s1) {
            hash[ch]++;
        }
        for (char ch : s2) {
            if (hash[ch] > 0) {
                hash[ch]--;
            }
        }
        for (int i : hash) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
