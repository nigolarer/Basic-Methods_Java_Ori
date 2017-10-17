package intv.method.linklist;


import java.util.Scanner;
import java.util.Stack;

/*
*单链表
* 单链表的插入删除等操作
*
* */
class Node {//定义节点
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
    Node() {
    }
}
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        Node head = null;
        head = addNode(head);
        //int pos = findNode(head);
        //System.out.println("pos at:"+pos);

       // head = deleteNode(head);
       // showList(head);
       // showListReverse(head);
        showListReverseRecursion(head);
        
    }

    private static void showListReverseRecursion(Node node) {//递归的方式反向输出链表
        if (node == null) {
            return;
        }
        else if (node.next != null) {
            showListReverseRecursion(node.next);
        }
        System.out.print(node.data+" ");
    }

    private static void showListReverse(Node node) {//非递归,使用栈方式反向输出链表
        Stack<Node> stack = new <Node>Stack(); // 创建堆栈对象
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while(!stack.empty()){//output stack

            System.out.print (stack.pop().data+" ");
        }

    }

    private static Node deleteNode(Node head) {
        Node node = head;
        System.out.println("input a num u want to delete");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (node.data == num && node.next == null) {//head node only and hit
            node = null;
            return node;
        } else {//not only head node
            Node tmpn;
            if (node.data == num) { //if head node's data equals num(but head node has next)
                tmpn = node;
                node= node.next;
                tmpn = null;
                return node;
            }
            int count = 0;
            while (node != null) {//if head node doesn't hit traverse list
                count ++;
            if (node.next != null && node.next.data == num) {//if node.next.data equals num
                if (node.next.next != null) {//if hit node is the last node
                    tmpn = node.next;
                    node.next = node.next.next;
                    tmpn = null;
                    System.out.println("pos"+count);
                    return head;
                }
                else {//hit node is last node(rear node)
                    node.next = null;
                    System.out.println("pos"+count);
                    return head;
                }
            }
            node = node.next;
            }

        }
        System.out.println("delete nothing");
        return head;
    }

    private static int findNode(Node head) {
        int pos = 0;
        Node node = head;
        System.out.println("input a num");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while (node != null) {
            if (node.data == num) {
                return pos;
            }
            ++pos;
            node = node.next;
           // System.out.println(""+node);
        }
        return -1;
    }

    //添加新节点,这里是用尾插法
    private static Node addNode(Node head) {
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        Node node = head;
        if (n < 1) {
            return head;
        }
        if (node != null){
            while (node.next != null) {
                node = node.next;
            }

        }
        else {
            head = new Node(scan.nextInt());
            node = head;
            n = n - 1;
        }
        for (int i = 0; i < n; i++) {
            node.next = new Node(scan.nextInt());
            node = node.next;
        }
        return head;

    }

    private static void showList(Node node) {//输出链表
        while (node != null) {
            System.out.print(""+node.data+" ");
            node = node.next;
        }

    }
}
