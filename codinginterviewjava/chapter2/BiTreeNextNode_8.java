package codinginterviewjava.chapter2;
class  BiTreeNode{
    int value;
    BiTreeNode lChild;
    BiTreeNode rChild;
    BiTreeNode parent;
    BiTreeNode(int value) {
        this.value = value;
    }
    BiTreeNode() {

    }
}
/**
 * 获取二叉树某个结点的中序遍历下一个节点
 * 这里首先由一个想法就是:中序遍历整个树,根据值扫描中序遍历序列,获取值来查找下一个结点.
 * 但是题目的目的不在这里,他给定一个结点,要求根据当前节点来获取中序下一个节点,
 * 也就是说,其实是没有告诉根节点的.如果先找到根,再获取整个中序序列然后再找到
 *
 * 此时,需要思考中序遍历的步骤了:
 * 1.中序遍历按照左中右的步骤递归遍历
 * 2.这里,下一位是递归到下面该返回到上一层的时候发生的事情.
 *  a.如果当前节点有左孩子,那么肯定先访问左孩子,最后才访问自己,然后访问右孩子,所以左孩子对该节点没意义
 *  b.如果当前节点有右孩子,那么按照左中右的访问规则,先访问左孩子,然后访问根,至于右孩子,由于根优先,所以
 *    右孩子不会是下一个.只要找到右子树里向左孩子方向找到第一个没有左孩子的节点即可.
 *  c.如果当前节点没有右孩子,那么按照中序遍历的顺序,返回递归的上层,递归的上层又分为两种情况:
 *    如果是(中序左中右里的)左孩子返回,这个时候,下一个元素就是这个父结点自身,
 *  d.如果是右孩子返回,那么下一个节点就需要继续向上层返回,直到下层是上层是一个左孩子为止.
 * */
public class BiTreeNextNode_8 {
    public static void main(String[] args) {
        BiTreeNode root = new BiTreeNode(0);
        BiTreeNode n1 = new BiTreeNode(1);
        BiTreeNode n2 = new BiTreeNode(2);
        BiTreeNode n3 = new BiTreeNode(3);
        BiTreeNode n4 = new BiTreeNode(4);
        BiTreeNode n5 = new BiTreeNode(5);
        root.lChild = n1;
        root.rChild = n4;
        n1.lChild = n2;
        n1.rChild = n3;
        n4.rChild = n5;

        n1.parent = root;
        n2.parent = n1;
        n3.parent = n1;
        n4.parent = root;

        InOrder(root);

        int valuer = getBiTreeNextNode(root);
        int value = getBiTreeNextNode(n1);
        int value2 = getBiTreeNextNode(n2);
        int value3 = getBiTreeNextNode(n3);
        int value4 = getBiTreeNextNode(n4);
        int value5 = getBiTreeNextNode(n5);
        System.out.println();
        System.out.println(valuer+" "+value+" "+ value2+" "+value3+" "+value4+" "+value5);
    }
    /**
     * 获取某个结点的中序遍历下一个节点
     * */
    private static int getBiTreeNextNode(BiTreeNode n3) {
        if (n3 == null) {
            return -1;
        }
        if (n3.rChild != null) {
            BiTreeNode tmp = n3.rChild;
            while (tmp.lChild != null) {
                tmp = tmp.lChild;
            }
            return tmp.value;
        } else {
            while (n3.parent!=null) {
                if(n3.parent.lChild != null && n3 == n3.parent.lChild) {
                    return n3.parent.value;
                }
                else if(n3.parent.rChild != null && n3 == n3.parent.rChild) {
                    n3 = n3.parent;
                }
            }

        }
        return -1;
    }

    /**中序遍历*/
    private static void InOrder(BiTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.lChild != null) {
            InOrder(node.lChild);
        }
        System.out.print(node.value + " ");
        if (node.rChild != null) {
            InOrder(node.rChild);
        }
    }
}
