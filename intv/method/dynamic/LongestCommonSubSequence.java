package intv.method.dynamic;

import intv.common.HandleString;

import java.util.Scanner;

/**
 * ********未实现***********
 * 求两个字符串的最长公共子串
 * 注意,这里的子序列不是子串,比如ABCDEFG 他的子序列很多,AC ADEG DEG BCF等都是子序列
 * 两个字符串的公共子序列,如ABCD,EJLASBCDFHS 他们的最长公共子序列为ABCD
 *
 * */
public class LongestCommonSubSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] s1 = scan.next().toCharArray();
        //char[] s2 = scan.next().toCharArray();
        //HandleString.show(s1);

        getSubSequence(s1,0,0+1);
        
    }

    private static char getSubSequence(char[] s1,int head,int left) {
        for (int i = head; i < s1.length; i++) {
            int j = i;
            while (s1[j] != '\0') {
                System.out.println(s1[i]+" "+getSubSequence(s1,i,j));
            }
            while (s1[j] != '\0') {
                System.out.println(" "+getSubSequence(s1,i,j));
            }
        }
        return s1[head];
    }
}
