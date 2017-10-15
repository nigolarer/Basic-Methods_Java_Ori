package intv.method.basic;
class BinarySortTreeNode{
    BinarySortTreeNode lchild;
    BinarySortTreeNode rchild;
    int data;
    BinarySortTreeNode(){}
    BinarySortTreeNode(int data){
        this.data = data;
    }


}

public class BinarySortTreeTest {
    public static void main(String[] args) {
        BinarySortTreeNode root = new BinarySortTreeNode(1);
        BinarySortTreeNode node1 = new BinarySortTreeNode();
        BinarySortTreeNode node2 = new BinarySortTreeNode();
        int[] a = {17, 5, 1, 12, 38, 21, 312, 143, 172, 312, 43, 123, 112, 36, 127};
         buildBinarySortTree(a , root);
        showTree(root);
    }

    private static void showTree(BinarySortTreeNode root) {
        //System.out.println();
        System.out.print("" + root.data + " ");
        if (root.lchild != null) {
            showTree(root.lchild);
        }

        if (root.rchild != null) {
            showTree(root.rchild);
        }

    }

    private static BinarySortTreeNode buildBinarySortTree(int[] a, BinarySortTreeNode root) {
        BinarySortTreeNode node = root;
        boolean tmp;
        root.data = a[0];
        for(int i = 1;i<a.length;i++) {
            tmp = false;
            node = root;
            while (tmp == false) {
                if (node.data >= a[i]) {
                    if (node.lchild == null) {
                        node.lchild = new BinarySortTreeNode(a[i]);
                        node = node.lchild;
                        tmp = true;
                    } else {
                        node = node.lchild;
                    }

                }
                if (node.data < a[i]) {
                    if (node.rchild == null) {
                        node.rchild = new BinarySortTreeNode(a[i]);
                        node = node.rchild;
                        tmp = true;
                    } else {
                        node = node.rchild;
                    }

                }


            }
        }
       /* for(int i = 1;i<a.length;i++) {
            node = root;
            while (node.lchild != null && node.rchild != null) {
                if (a[i] > node.data) {
                    node = node.rchild;
                } else {
                    node = node.lchild;
                }
            }
            if (node.lchild == null && a[i]<= node.data) {
                node.lchild = new BinarySortTreeNode(a[i]);
                node = node.lchild;
            }
            else{
                node.rchild = new BinarySortTreeNode(a[i]);
                node = node.rchild;
            }
        }*/
        System.out.println("return");
        return root;

    }
}
