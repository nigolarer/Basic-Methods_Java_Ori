package codinginterviewjava.chapter2;

import intv.common.biTreeNode;
import intv.util.TraversalBTree;
import java.util.Scanner;
/*class biTreeNode {
    int value;
    biTreeNode lchild;
    biTreeNode rchild;
    biTreeNode(){}
    biTreeNode(int value){
        this.value = value;
    }
}*/
/**
 * 面试题7
 * 根据先序遍历和中序遍历生成二叉树:
 * 先序12473568
 * 中序47215386
 * 这里需要注意,递归构建二叉树和做题手工构建二叉树的感觉或者说风格不一样,因为递归是先不断递归的构建左孩子
 * 直到没有左孩子后再去找右孩子,而人的思维是一直在找子树的根(虽然也是找左右孩子,但是是从根出发),然后根据
 * 左右子树的根找到左右子树.
 *
 * 步骤很简单:
 * 1.根据先序找到根,
 * 2.根据根在中序定位左右子树
 * 3.根据定位的左右子树,确认先序的左右子树
 * 4.根据2,3划分子的左右先序中序序列分别带入递归,构建左右子树,并重复1,2,3,4
 * */
public class BiTreeBuild_7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //中序序列
        char[] inOrder;
        char[] preOrder;
        preOrder = scan.next().toCharArray();
        inOrder = scan.next().toCharArray();
        biTreeNode root = buildBiTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
        //按照先序和中序打印
        TraversalBTree.preOrderTraversalBTree(root,"char");
        System.out.println();
        TraversalBTree.inOrderTraversalBTree(root,"char");
    }

    private static biTreeNode buildBiTree(char[] preOrder, int prehead, int prerear, char[] inOrder, int inhead, int inrear) {
        biTreeNode node ;
        //非法输入判断
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
            return null;
        }
        //递归到序列长度为1时,中序和先序应该元素是一样的,此时创建结点并返回给根节点的孩子指针
        if (prehead == prerear) {
            if (inhead == inrear) {
                return new biTreeNode(preOrder[prehead]);
            }
            //如果中序和先序不同,则一定是序列有问题
            else {
                return null;
            }
        }
        //序列长度不为1时,证明还有子树进入else
        else {
            //以先序序列的第一个结点值生成根节点
            node = new biTreeNode(preOrder[prehead]);
            //创建searchNode临时变量,用来遍历查找中序序列中的根节点位置
            int searchNode = inhead;
            while (inOrder[searchNode] != preOrder[prehead] && searchNode < inrear) {
                searchNode++;
            }
            //查找结束后如果还是没有找到,证明序列出错返回null(此时应该报错而不是返回空)
            if (inOrder[inrear] != preOrder[prehead] && searchNode == inrear) {
                return null;
            }
            //根据searchNode计算左子树长度
            int lLength = searchNode - inhead ;
            //lLength大于0,则说明有左孩子,左孩子通过递归获取
            if (lLength > 0) {
                //根据左子树长度计算先序遍历中的左子树长度,作为子序列的列尾即:prehead+lLength
                node.lchild = buildBiTree(preOrder, prehead + 1, prehead+lLength, inOrder, inhead, searchNode - 1);
            }
            //如果lLength小于序列长度中序序列的长度-1,则说明有右孩子.注意: inrear-inhead+1=中序序列长度
            if (lLength < inrear - inhead) {
                node.rchild = buildBiTree(preOrder,prehead+lLength+1,prerear,inOrder,searchNode+1,inrear);
            }
        }
        return node;
    }
}
