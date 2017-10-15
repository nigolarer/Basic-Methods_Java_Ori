package intv.method.basic;

/*
* string中按照逗号将内容存到string数组中
* */
public class SplitStringTest {
    public static void main(String[] args) {
        String s = "12,15,17,19,2,21,44";
        StringBuffer stringBuffer = new StringBuffer(s);
        //stringBuffer.
        String[] s2 = s.split(",");
        for (String iterator : s2) {
            System.out.println(iterator);
        }
    }

}
