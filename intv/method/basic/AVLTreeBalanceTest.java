package intv.method.basic;

class BiTree {
    int data;
    BiTree lchild;
    BiTree rchild;
    BiTree(int data){
        this.data = data;
    }
    BiTree(){}
}

public class AVLTreeBalanceTest {
    public static void main(String[] args) {
        BiTree root = new BiTree(1);
        BiTree node2 = new BiTree(2);
        BiTree node3 = new BiTree(3);
        BiTree node4 = new BiTree(4);
        BiTree node5 = new BiTree(5);
        root.lchild = node2;
        root.rchild = node3;
        node3.lchild = node4;
        node4.rchild = node5;
        //node5.rchild = root;// haha, java.lang.StackOverflowError
        int high = showHigh(root);
        System.out.println(high);
        System.out.println(""+judgeBalance(root));
        showBiTree(root);//中序遍历
    }

    private static boolean judgeBalance(BiTree root) {
        int highl = showHigh(root.lchild);
        int highr = showHigh(root.rchild);
        if(Math.abs(highl - highr)>1){
            return false;
        }else
            return true;
    }

    private static int showHigh(BiTree node) {//判断树高
        int highl = 0;
        int highr = 0;
        //System.out.println("node data = "+ node.data);
        if (node.lchild == null && node.rchild == null) {
            return 1;
        }
       else if (node.lchild == null && node.rchild != null) {
            highr = showHigh(node.rchild)+1;
        } else if (node.lchild != null && node.rchild == null) {
            highl = showHigh(node.lchild) + 1;

        } else {
            highl = showHigh(node.lchild) + 1;
            highr = showHigh(node.rchild)+1;
        }
        if (highl > highr) {
            return highl;
        }
        else {
            return highr;
        }
    }

    private static void showBiTree(BiTree node) {//中序遍历
        if (node.lchild != null) {
            showBiTree(node.lchild);
        }
        System.out.print(node.data+" ");
        if (node.rchild != null) {
            showBiTree(node.rchild);
        }
    }
}
