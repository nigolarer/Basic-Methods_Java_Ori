package intv.method.basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/*
* 测试迭代器的使用以及list的使用
* 这里使用的是linkedList
* List <String> ll = new LinkedList <String>(); 这个左边使用了List而不是 Linkedlist
* */
public class IteratorTest {
    public static void main(String[] args) {
        List <String> ll = new LinkedList <String>();
        ll.add("a");
        ll.add("b");
        ll.add("c");
        String[] s = new String[10];
        s[0] = ll.get(1);
        System.out.println(s[0]);//not used Iterator but get elements

        Iterator it = ll.iterator();
        System.out.println("hello "+(String)it.next());

    }
}
