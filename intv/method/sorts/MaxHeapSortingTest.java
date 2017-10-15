package intv.method.sorts;
/*
* 堆排序(大顶堆)算法
*
* 堆是完全二叉树用一维数组按层序存储的
* 堆排序的主要思路是:
* 1.建立大顶堆
* 2.将堆顶元素放在数组末尾(准确的说法是,堆顶元素与堆尾元素交换),堆长度减1
* 不断执行这两部操作直到堆只有一个元素
*
* 其中,第二步很简单,只是简单的数组中两个节点交换
* 第一步简单但是步骤较多,堆排序的核心也就是这个建立大顶堆的过程
* 过程如下:
* 1.根据完全二叉树性质,第i/2到根节点每个节点都有孩子,i/2这个节点可能会没有右孩子
* 2.大顶堆的特点就是根节点比左右孩子都要大.递归满足这个条件就行了
* 3.实现大顶堆其实就是从i/2个结点开始往根节点,不断跟自己的左右孩子比较,如果小于左右孩子,则交换
*   否则i/2 - 1判断,这里,如果发生了交换,那么需要递归的判定交换后的节点一直到叶子结点
*   例如:                 2
*                   10         9
*                 8    7
*   这里,2由于比10小,交换2与左孩子10,交换后,由于2又比8小,所以交换2与左孩子8
*   即:                 *10                        10
*                  *2         9    ---->     *8         9
*                8    7                   *2     7
*   每一次向上走一个节点,都需要先和左右孩子比较,如果发生了交换则递归的向下交换.
*   一直走到根节点并完成根节点与左右孩子的递归交换后,大顶堆就建立完成了
* */
public class MaxHeapSortingTest {
    void Test() {
        System.out.println("hello!");
    }
    public static void main(String[] args) {
        MaxHeapSortingTest maxHeapSorting = new MaxHeapSortingTest();
        maxHeapSorting.Test();
       // String s = "10,2,23,1,23,1,23,83,312,3,66,123,487,131,78,1,21,34,7";
        String s = "10,2,23,226,1,73,83,312,3,66,123,999";
        String[] t = s.split(",");
        int[] intS = maxHeapSorting.toCharString(t);
        printIntS(intS);
        //intS = maxHeapSorting.buildMaxHeap(intS, intS.length);
        /*
        * 每次建立完堆后将堆顶元素与数组最后一个元素交换,并让堆的长度减一再重新build堆
        *
        * */
        for (int i = intS.length; i > 0; i--) {
            maxHeapSorting.buildMaxHeap(intS,i);
            doswap(intS, 0, i-1);
            System.out.println("the "+(intS.length-i+1)+" times order is:");
            printIntS(intS);
        }
        printIntS(intS);

    }

    private static void doswap(int[] intS, int head, int rear) {
        if (intS == null) {
            return;
        }
        int tmp;
        tmp = intS[head];
        intS[head] = intS[rear];
        intS[rear] = tmp;
    }

    /*
    * 打印INT数组
    * */
    private static void printIntS(int[] intS) {
        for (int iter : intS) {
            System.out.print(iter+" ");
        }
        System.out.println();
    }
    /*
    * String数组转int数组
    * */
    private int[] toCharString(String[] t) {
        int[] intS = new int[t.length];
        int i  = 0;
        for (String iter : t) {
            intS[i++] = Integer.parseInt(iter);
        }
        return  intS;
    }

    private   int[] buildMaxHeap(int[]t, int length) {
        if (t == null || length <= 0) {
            return null;
        }
        for (int i = length / 2; i >= 0; i--) {
            orderNode(t,i,length);

        }
        return t;
    }

    /*
    * 维护数组 使之成为大顶堆
    * 这个方法中不讨巧的多定义了一些其实不必要的变量,为了看起来清楚
    * 备注:大顶堆其实就是完全二叉树,所以满足完全二叉树的结构,最重要的就是i结点如果小于len/2
    * 那么2i就是节点的左孩子,2i+1就是右孩子,对于这里,由于根节点是0开始的,所以需要分别加1才
    * 能得到左右孩子节点
    *
    * 大致过程:
    * 首先,判断i节点是否有左右孩子,并分别记录给lChild和rChild
    * 其次,判断i结点和左右孩子节点的大小,先比较左孩子,小则交换,再比较右孩子
    * 小则交换,这样做后i结点就一定是3个节点中最大的结点
    * 再次,如果发生了交换,那么需要记录交换的结点位置,比如右孩子节点的位置
    * 因为发生交换后,还有可能导致右孩子往下的堆不满足大顶堆,需要类似递归的交换
    * 如果没有发生交换,那么证明堆已经成型了
    *
    * 注意,这里如果有只有左孩子的节点,那么右孩子的值假定为-999,这样保证不会发生越界交换等情况
    *
    * */
    private void orderNode(int[]  t, int i,int len) {
        int lChild;
        int rChild;
        int cNode = t[i];
        int pos = i;
        while (true) {
            if (i * 2 +1 < len) {
                lChild = t[i * 2 + 1];
            }
            else{
                return;
            }
            if (i * 2 + 2 < len) {
                rChild = t[i * 2 + 2];
            } else {//针对只有左孩子的情况
                rChild = -999;
            }
            System.out.println("cnode = "+cNode+" previously is :t["+i+"]: "+t[i]+" lchild "+ lChild+" rChild "+rChild);

            if (cNode < lChild) {
                t[i * 2+1] = cNode;
                t[i] = lChild;
                cNode = t[i];
                lChild = t[i * 2+1];
                pos = i*2+1;
            }
            if (cNode < rChild) {
                t[i * 2 + 2] = cNode;
                t[i] = rChild;
                cNode = t[i];
                rChild = t[i * 2 + 2];
                pos = i*2+2;
            }
            if (i != pos) {
                i = pos;
                cNode = t[i];
                System.out.println("do switch then become i = "+i+" lchild "+ lChild+" rChild "+rChild);
                printIntS(t);
            } else {
                System.out.println("didnt change");
                return;
            }

        }
    }

}
