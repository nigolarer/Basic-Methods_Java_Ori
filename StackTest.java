import java.util.Scanner;
/*
* 入栈和出栈的实践
*
* */
public class StackTest {
    static int rear;
    public static void main(String[] args) {
        Scanner s;
        s = new Scanner(System.in);
        //int len = s.nextInt();
        int[]a = new int[10];
/*        int[] a = new int[len];

        int num = s.nextInt();
        for(int i = 0;i<len;i++){
            if (num == -1) {
                break;
            } else {
                a[i] = num;
                num = s.nextInt();
            }
        }*/
        int num = s.nextInt();
        push(a,num++);
        push(a,num++);
        push(a,num++);
        push(a,num++);

        System.out.println(rear);
        System.out.println("pop out:"+pop(a));
        for (int iterator : a) {
            System.out.print(" "+iterator);
        }
    }

    private static int pop(int[] a) {
        int tmp = a[rear-1];
        a[rear-1] = 0;
        rear--;
        return tmp;
    }

    private static void push(int[] a, int num) {
        a[rear] = num;
        rear++;
    }


}
