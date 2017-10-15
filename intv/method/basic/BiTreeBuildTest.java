package intv.method.basic;

import java.util.Scanner;
class bitreeNode{
    int value;
    bitreeNode lchild;
    bitreeNode rchild;
    bitreeNode(){}
    bitreeNode(int value){
        this.value = value;
    }
}
public class BiTreeBuildTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] inOrder;
        char[] postOrder;
        inOrder = scan.next().toCharArray();
        postOrder = scan.next().toCharArray();
        // doBuildBiTree(inOrder,0,0,postOrder,0,postOrder.length-1);
        bulidBiTree(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private static bitreeNode bulidBiTree(char[] postOrder, int phead, int prear, char[] inOrder, int ihead, int irear) {
        bitreeNode node ;
        if (postOrder == null || inOrder == null || postOrder.length != inOrder.length) {
            return null;
        }
        if (ihead == irear) {
            return new bitreeNode(postOrder[ihead]);
        }
        else {
            node = new bitreeNode(postOrder[phead]);
            int searchNode = ihead;
            while (inOrder[searchNode+1] != postOrder[phead]&& searchNode+1<inOrder.length) {
                searchNode++;
            }
            if (ihead == inOrder.length - 1&&inOrder[ihead+1] != postOrder[phead]) {
                return null;
            }
            int lLength = irear - ihead;
            prear = phead+lLength;
            if (lLength > 0) {
                node.lchild = bulidBiTree(postOrder, phead + 1, prear, inOrder, ihead, searchNode - 1);

            }
            if (lLength < prear - phead) {
                node.rchild = bulidBiTree(postOrder,lLength+1,prear,inOrder,searchNode,irear);
            }
        }

        return node;
    }


    /*
    * doBuildBiTree
    * 这个版本写的并不好,并且没有实现
    * 关于思路也不是很清晰
    *
    * */
    private static bitreeNode doBuildBiTree(char[] inOrder, int ihead,int irear, char[] postOrder, int phead,int prear) {
        if (inOrder.length != postOrder.length) {//长度异常不判断直接退出
            return null;
        }
        //System.out.println(postOrder[phead]);//打印
        bitreeNode node = new bitreeNode(postOrder[phead]);
        if (phead< inOrder.length) {
            //遍历左节点
            while (inOrder[irear+1] != postOrder[phead]&&irear+1<prear) {
                irear += 1;
                System.out.println(irear);
            }
            node.lchild = doBuildBiTree(inOrder,phead,irear,postOrder,phead+1,irear+1);
            if (irear + 3 < inOrder.length) {
                node.rchild = doBuildBiTree(inOrder,irear+2,inOrder.length-1,postOrder,irear+2,inOrder.length-1);
            }
        }
        return  node;
    }
}
