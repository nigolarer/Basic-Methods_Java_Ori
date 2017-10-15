package intv.method.linkList;

import java.util.Scanner;

/*
* 判断是否为循环节点并且寻找入口结点
* 包括了
* 1.生成链表
* 2.判断循环
* 3.计算循环的长度
* 4.找打入口结点(的值)
* 5.打印链表(用于测试和直观展现)
*
* */

//结点定义
class listNode {
    int value;
    listNode next;

    listNode() {

    }

    listNode(int value) {
        this.value = value;
    }

}

//主函数
public class loopListTesting {

    public static void main(String[] args) {
        int n = 10;
        Scanner scan = new Scanner(System.in);//输入链表长度
        n = scan.nextInt();
        listNode head = createLoopList(n);
        listNode node = judgeLoop(head);
        if (node != null) {
            System.out.println("meet at node value :"+node.value);
        }
        int count = countLoopNodes(node);
        System.out.println("loop count is :"+count);
        node = findEntrance(head,count);
        if (node != null) {
            System.out.println("entrance node value :"+node.value);
        }
        showList(head);
    }
/*
* 找到环的入口结点
* 首先,需要计算环的长度n
* 其次,让第一个指针先走n,再让第二个指针开始与第一个一起走,则相遇时就是入口
* */
    private static listNode findEntrance(listNode head, int count) {
        if (head == null || count <= 0) {
            return null;
        }
        listNode enNode = head;
        for(int i = 0;i<count;i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != enNode) {
            if (head == null) {
                return null;
            }
            head = head.next;
            enNode = enNode.next;
        }
        return enNode;
    }
/*
*
* 判断循环链表的长度
*
* */
    private static int countLoopNodes(listNode node) {
        if (node == null) {
            return 0;
        }
        listNode node2 = node;
        int count = 1;
        while (node.next != node2) {
            node = node.next;
            count++;
        }
        return count;
    }

    /*
    * 设置两个指针,快指针和慢指针,如果相遇则返回相遇的结点
    *
    * */
    private static listNode judgeLoop(listNode node) {
        if (node == null) {
            return null;
        }
        listNode node2= node;
        while (node != null) {
/*            if (node.next == null || node2.next == null) {//这里冗余,因为如果node为空最后会返回null
                return null;
            }*/
            node = node.next;
            node2 = node2.next;
            if (node.next != null) {//相当于node.next.next 这里这样做是怕空指针异常
                node = node.next;
            } else {
                return  null;
            }
            if (node == node2) {
                return  node;
            }
        }
        return null;
    }

    //测试打印链表,如果是循环链表则会死循环
    private static void showList(listNode node) {
        int count = 999;
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



    /*
    *
    * 创建一个长度为n的单链表,随机在某个结点作为单链表的环形入口
    *
    * */
    private static listNode createLoopList(int n) {
        int random = (int)(Math.random()*1000%n);//注意这里的括号,如果不加括号则会先转整型导致失效
        System.out.println("random num is :"+random);
        if (n <= 0) {
            return null;
        } else {
            listNode head = new listNode((int)(Math.random()*1000%n));
            listNode node = head;
            listNode randomNode = head;
            for(int i = 1;i<n;i++) {
                if (random == i) {
                    randomNode = node;
                }
                node.next = new listNode((int)(Math.random()*1000%n));
                node = node.next;
            }
            showList(head);
            node.next = randomNode;
            return head;
        }
    }
}
