package intv.util;

import intv.common.biTreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static intv.util.TraversalBTree.inOrderTraversalBTree;
import static intv.util.TraversalBTree.preOrderTraversalBTree;

public class GenerateBTree {
    static private  int maxValue = 10;
    //设置结点的最大值
    public static boolean setMaxValue(int n) {
        if (n > 0) {
            maxValue = n;
        }
        return false;
    }

    //生成一棵n个结点的树
    public static int generateChild(Queue<biTreeNode> q1, Queue<biTreeNode> q2, int n) {
        biTreeNode node  = null;
       // int n = 1;
        while (!q1.isEmpty() && n > 0) {
            node = q1.poll();
            int ran = RandomNum.getRandom(3);
            //System.out.println("ran:"+ran);
            if (ran== 0) {//试图创建双节点
                System.out.print(node.value+" create rchild");
                node.rchild = new biTreeNode(RandomNum.getRandom(maxValue));
                q2.add(node.rchild);
                n--;
                if (n > 0) {
                    System.out.println(" and lchild");
                    node.lchild = new biTreeNode(RandomNum.getRandom(maxValue));
                    q2.add(node.lchild);
                    n--;
                }
            } else if (ran == 1 && n > 0) {//创建左子树
                System.out.println(node.value+" create lchild");
                node.lchild = new biTreeNode(RandomNum.getRandom(maxValue));
                q2.add(node.lchild);
                n--;
            } else if (ran == 2 && n > 0) {
                System.out.println(node.value+" create rchild");
                node.rchild = new biTreeNode(RandomNum.getRandom(maxValue));
                q2.add(node.rchild);
                n--;
            } else {
                break;
            }

        }
        return n;
    }
    public static biTreeNode getBTree(int n) {
        if (n == 0) {
            return  null;
        }
        Queue<biTreeNode> q1,q2;
        q1 = new LinkedList <biTreeNode>();
        q2 = new LinkedList <biTreeNode>();
        biTreeNode root  = new biTreeNode(RandomNum.getRandom(maxValue));
        q1.add(root);
        n--;
         while (n > 0) {
            n = generateChild(q1,q2,n);

            /*Iterator <biTreeNode> it  = q2.iterator();
             System.out.println("n:"+n);
            while (it.hasNext()){
                System.out.print(it.next().value+" ");
            }
            System.out.println();*/
            System.out.println("inOrder:");
            inOrderTraversalBTree(root);//中序遍历
            System.out.println();
            System.out.println("preOrder:");
            preOrderTraversalBTree(root);//先序遍历
            System.out.println();
            n = generateChild(q2,q1,n);
           /* it  = q1.iterator();
            while (it.hasNext()){
                System.out.print(it.next().value+" ");
            }
            System.out.println();*/
            System.out.println("inOrder:");
            inOrderTraversalBTree(root);//中序遍历
            System.out.println();
            System.out.println("preOrder:");
            preOrderTraversalBTree(root);//先序遍历
            System.out.println();
        }

       /* if (n > 0) {
            node = new biTreeNode(RandomNum.getRandom(maxValue));
            int ra  = RandomNum.getRandom(100);
            System.out.println("ra%3:"+ra%3);
            if (ra%3 == 0) {//随机生成1或者0分别对应于生成左子树或者右子树
                node.lchild = new biTreeNode(RandomNum.getRandom(maxValue));
                node.rchild = new biTreeNode(RandomNum.getRandom(maxValue));

            } else if (ra % 3 == 1) {
                node.rchild = new biTreeNode(RandomNum.getRandom(maxValue));
            } else {
                node.lchild = new biTreeNode(RandomNum.getRandom(maxValue));
            }
        }*/
        return root;
    }


}
