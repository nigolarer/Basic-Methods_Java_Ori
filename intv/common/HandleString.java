package intv.common;
/**
 * @author nigolarer
 * 转换字符串
 * 打印字符串
 *
 * */
public class HandleString {
    public void show(String s) {
        if (s == null) {
            return;
        }
        char[] ch = s.toCharArray();
        for (char iter : ch) {
            System.out.print(ch+" ");
        }
        System.out.println();
    }

    public static void show(char[] chars) {
        if (chars == null) {
            return;
        }
        for (char iter : chars) {
            System.out.print(iter+" ");
        }
        System.out.println();
    }
}
