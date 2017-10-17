package intv.method.linklist;

/*//同package中有
class listNode {
    int value;
    listNode next;

    listNode() {

    }

    listNode(int value) {
        this.value = value;
    }

}*/

import java.util.Scanner;

public class MergeList
{
    public static void main(String[] args) {
        /*listNode head = new listNode();*/
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        listNode head1 = generateOrderedList(num1);
        showList(head1);
        listNode head2 = generateOrderedList(num2);
        showList(head2);
        listNode headm = mergeList(head1, head2);
        showList(headm);
    }

    private static listNode mergeList(listNode head1, listNode head2) {
        if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        listNode head = null;
        if (head1.value > head2.value) {
            head = head2;
            head.next = mergeList(head1, head2.next);
        } else {
            head  = head1;
            head.next = mergeList(head1.next, head2);
        }
        return head;
    }


    //打印链表
    private static void showList(listNode node) {
        int count = 9999;
        while (node != null && count>0) {
            System.out.print(node.value+" ");
            node = node.next;
            count--;
        }
        if (count<=0) {
            System.out.println("\nexpired length");
        }
        System.out.println();
    }

    //生成一个递增的单链表
    private static listNode generateOrderedList(int num) {
        if (num <= 0) {
            return null;
        }
        int seed = (int) (Math.random()*10000%100);//生成一个100以内大小的随机数
        listNode head = new listNode(seed);
        listNode node = head;
        while (num > 1) {
            num--;
            /*
             *生成10以内的偏差值,注意这里int可以定义内部,
             *虽然会造成栈的调整,但是hashmap都这么做的,这样做比较符合安全性不容易被错误引用
             *
             */
            int bias = (int)(Math.random()*1000%10);
            seed += bias;
            node.next = new listNode(seed);
            node = node.next;
        }
        return head;
    }
}
