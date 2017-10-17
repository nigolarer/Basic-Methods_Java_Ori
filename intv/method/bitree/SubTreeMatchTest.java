package intv.method.bitree;
import intv.common.biTreeNode;
import  intv.util.*;
import static intv.util.TraversalBTree.*;

/* //已经在common包中
class biTreeNode {
    biTreeNode lchild;
    biTreeNode rchild;
    int value;
    biTreeNode() {
    }
    biTreeNode(int value) {
        this.value = value;
    }
}*/

/*
* 子树的匹配问题
* 目前未完成,只实现了创建一棵二叉树
* */
public class SubTreeMatchTest {
    public static void main(String[] args) {
        GenerateBTree.setMaxValue(100);
        biTreeNode root = GenerateBTree.getBTree(10);
        System.out.println("final result:\n");
        System.out.println("inOrder:");
        inOrderTraversalBTree(root);//中序遍历
        System.out.println();
        System.out.println("preOrder:");
        preOrderTraversalBTree(root);//先序遍历
        System.out.println();

    }
}
